package com.safra.safrat6.listener.JSON;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class TransactionJSON implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
private final String accountId;
  private final String transactionId;
  private final String transactionInformation;

  public TransactionJSON(
      @JsonProperty("accountId") String accountId,
      @JsonProperty("transactionId") String transactionId,
      @JsonProperty("transactionInformation") String transactionInformation) {
    this.accountId = accountId;
    this.transactionId = transactionId;
    this.transactionInformation = transactionInformation;
  }

  public String getAccountId() {

    return accountId;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public String getTransactionInformation() {
    return transactionInformation;
  }

  @Override
  public String toString() {
    return "Transaction{" +
    		"accountId='" + accountId + "'" +
    		"transactionId='" + transactionId + "'" +
    		"transactionInformation='" + transactionInformation + "'" +
  " }";
  }
}
