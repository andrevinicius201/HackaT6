package com.safra.safrat6.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.safra.safrat6.entity.PrizeEntity;
import com.safra.safrat6.entity.StickerEntity;
import com.safra.safrat6.model.Prize;
import com.safra.safrat6.model.Sticker;
import com.safra.safrat6.repository.PrizeRepository;
import com.safra.safrat6.repository.StickerRepository;
import com.safra.safrat6.service.mapper.PrizeMapper;

@Service
public class PrizeService {

  @Autowired
  private PrizeRepository prizeRepository;

  @Autowired
  private StickerRepository stickerRepository;

  @Autowired
  private PrizeMapper prizeMapper;

  @Autowired
  private AmazonS3 amazonS3Client;

  @Value("${app.bucketName}")
  private String bucketName;

  @Transactional
  public Prize postPrize(Prize prize) {
    if (prize.getFile() != null) {
      File file = convertMultiPartFileToFile(prize.getFile());
      String uniqueFileName =
          System.currentTimeMillis() + "_" + prize.getFile().getOriginalFilename();
      uploadFileToS3bucket(uniqueFileName, file, bucketName);
      prize.setImageUrl(uniqueFileName);
    }
    PrizeEntity prizeEntity = prizeRepository.save(prizeMapper.toEntity(prize));
    prize.setId(prizeEntity.getId());

    List<Sticker> stickers = new ArrayList<>();
    List<StickerEntity> stickerEntities = new ArrayList<>();
    for (int i = 1; i <= prize.getColumnsQuantity() * prize.getRowsQuantity(); i++) {
      StickerEntity stickerEntity = new StickerEntity();
      stickerEntity.setPiece(i);
      stickerEntity.setPrize(new PrizeEntity(prize.getId()));
      stickerEntities.add(stickerEntity);
      stickers.add(new Sticker(i));
    }
    stickerRepository.saveAll(stickerEntities);
    prize.setStickers(stickers);
    prize.setFile(null);
    return prize;
  }

  private void uploadFileToS3bucket(String fileName, File file, String bucketName) {
    amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
  }

  private File convertMultiPartFileToFile(MultipartFile file) {
    File convertedFile = new File(file.getOriginalFilename());
    try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
      fos.write(file.getBytes());
    } catch (IOException e) {
      throw new IllegalArgumentException("Invalid file");
    }
    return convertedFile;
  }

}
