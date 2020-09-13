package com.safra.safrat6.listener.JSON;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safra.safrat6.type.TransactionInformation;

public final class TransactionJSON implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private final String accountId;
  private final String transactionId;
  private final TransactionInformation transactionInformation;
  private final BigDecimal value;
  private final String date;

  public TransactionJSON(
      @JsonProperty("accountId") String accountId,
      @JsonProperty("transactionId") String transactionId,
      @JsonProperty("transactionInformation") TransactionInformation transactionInformation,
      @JsonProperty("value") BigDecimal value,
      @JsonProperty("date") String date
      ) {
    this.accountId = accountId;
    this.transactionId = transactionId;
    this.transactionInformation = (transactionInformation);
    this.value = value;
    this.date = date;
  }

  public String getAccountId() {

    return accountId;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public TransactionInformation getTransactionInformation() {
    return transactionInformation;
  }

  public BigDecimal getValue() {
    return value;
  }

  public String getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "Transaction{"
        + "accountId='"
        + accountId
        + "' "
        + "transactionId='"
        + transactionId
        + "' "
        + "transactionInformation='"
        + transactionInformation.toString()
        + "' "
        + "value='"
        + value
        + "' "
        + "date='"
        + date
        + "'"
        + " }";
  }
}
