package com.safra.safrat6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safra.safrat6.repository.PrizeRepository;
import com.safra.safrat6.repository.StickerRepository;
import com.safra.safrat6.type.TransactionInformation;

@Service
public class StickerService {

  @Autowired private PrizeRepository prizeRepository;

  @Autowired private StickerRepository stickerRepository;

  private void distributeStickers(int idPrize, int accountId, int transactionId, int quantity) {}

  public void distributeStickers(int accountId, int transactionId, TransactionInformation transactionInformation) {
    //	  int idPrize = prizeRepository.getPrizeByAccount(accountId).id;
    int idPrize = 1;
    int quantity = 0;
    if (transactionInformation.equals(TransactionInformation.PURCHASE)) {
    	
      quantity = 1;

    } else if (transactionInformation.equals(TransactionInformation.DEBIT)) {
    	
      quantity = 2;

    } else if (transactionInformation.equals(TransactionInformation.INSURANCE)) {
    	
      quantity = 2;

    } else if (transactionInformation.equals(TransactionInformation.PAYMENTS)) {
    	
      quantity = 1;

    } else if (transactionInformation.equals(TransactionInformation.TRANSFER)) {
    	
      quantity = 1;

    } else if (transactionInformation.equals(TransactionInformation.DDA)) {
    	
      quantity = 2;
      
    } else if (transactionInformation.equals(TransactionInformation.LOAN)) {
    	
      quantity = 5;
      
    } else if (transactionInformation.equals(TransactionInformation.MEMBER_GET_MEMBER)) {
    	
      quantity = 10;
      
    } else if (transactionInformation.equals(TransactionInformation.NEW_ACCOUNT)) {
    	
      quantity = 10;
      
    } else if (transactionInformation.equals(TransactionInformation.INVESTMENT)) {
    	
      quantity = 5;
      
    }
    distributeStickers(idPrize, accountId, transactionId, quantity);
  }
}
