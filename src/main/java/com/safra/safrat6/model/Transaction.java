package com.safra.safrat6.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

  private String accountId;
  private String transactionId;
  private String transactionInformation;

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getTransactionInformation() {
    return transactionInformation;
  }

  public void setTransactionInformation(String transactionInformation) {
    this.transactionInformation = transactionInformation;
  }

}
