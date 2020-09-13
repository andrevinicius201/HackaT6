package com.safra.safrat6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safra.safrat6.model.Transaction;
import com.safra.safrat6.repository.PrizeRepository;
import com.safra.safrat6.type.TransactionInformation;

@Service
public class StickerService {

  @Autowired private AccountService accountService;

  public void distributeStickers(
      Transaction transaction, TransactionInformation transactionInformation) {
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
    transaction.setStickersQuantity(quantity);
    accountService.postTransaction(transaction.getAccountId(), transaction);
  }
}
