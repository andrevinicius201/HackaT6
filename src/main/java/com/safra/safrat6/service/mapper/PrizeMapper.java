package com.safra.safrat6.service.mapper;

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

}
