package com.safra.safrat6.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.safra.safrat6.entity.PrizeEntity;
import com.safra.safrat6.entity.StickerEntity;
import com.safra.safrat6.model.Sticker;

@Component
public class StickerMapper {

  public List<StickerEntity> toEntity(List<Sticker> stickers) {
    return stickers.stream().map(this::toEntity).collect(Collectors.toList());
  }

  public StickerEntity toEntity(Sticker sticker) {
    StickerEntity entity = new StickerEntity();
    entity.setPiece(sticker.getPiece());
    entity.setPrize(new PrizeEntity(sticker.getPrize().getId()));
    return entity;
  }

  public Sticker toModel(StickerEntity entity) {
    Sticker sticker = new Sticker();
    sticker.setId(entity.getId());
    sticker.setPiece(entity.getPiece());
    return null;
  }

}
