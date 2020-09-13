package com.safra.safrat6.service.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.safra.safrat6.entity.TransactionEntity;
import com.safra.safrat6.model.Transaction;

@Component
public class TransactionMapper {

  public TransactionEntity toEntity(Transaction transaction) {
    TransactionEntity entity = new TransactionEntity();
    entity.setId(new Long(transaction.getTransactionId()));
    entity.setDate(LocalDateTime.now());
    entity.setDescription(transaction.getTransactionInformation());
    entity.setQuantityStickers(transaction.getStickersQuantity());
    entity.setValue(transaction.getValue());
    return entity;
  }

}
