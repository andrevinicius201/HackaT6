package com.safra.safrat6.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.safra.safrat6.entity.PrizeEntity;
import com.safra.safrat6.model.Prize;

@Component
public class PrizeMapper {

  public PrizeEntity toEntity(Prize prize) {
    PrizeEntity entity = new PrizeEntity();
    entity.setDescription(prize.getDescription());
    entity.setImage(prize.getImageUrl());
    entity.setPrice(prize.getValue());
    entity.setColumnsQuantity(prize.getColumnsQuantity());
    entity.setRowsQuantity(prize.getRowsQuantity());
    return entity;
  }

  public List<Prize> toModel(List<PrizeEntity> prizes) {
    return prizes.stream().map(this::toModel).collect(Collectors.toList());
  }
  
  public Prize toModel(PrizeEntity entity) {
    Prize prize = new Prize();
    prize.setId(entity.getId());
    prize.setColumnsQuantity(entity.getColumnsQuantity());
    prize.setRowsQuantity(entity.getColumnsQuantity());
    prize.setDescription(entity.getDescription());
    prize.setImageUrl(entity.getImage());
    prize.setValue(entity.getPrice());
    return prize;
  }
}
