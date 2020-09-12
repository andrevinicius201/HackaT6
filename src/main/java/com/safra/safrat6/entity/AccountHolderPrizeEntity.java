package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "account_holder_prize")
@NamedQuery(name = "AccountHolderPrizeEntity.findAll",
    query = "SELECT a FROM AccountHolderPrizeEntity a")
public class AccountHolderPrizeEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "ACCOUNT_HOLDER_PRIZE_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "ACCOUNT_HOLDER_PRIZE_ID_GENERATOR")
  private Long id;

  // bi-directional many-to-one association to AccountHolderEntity
  @ManyToOne
  @JoinColumn(name = "account_holder_id")
  private AccountHolderEntity accountHolder;

  // bi-directional many-to-one association to AccountHolderPrizeStatusEntity
  @ManyToOne
  @JoinColumn(name = "account_holder_prize_status_id")
  private AccountHolderPrizeStatusEntity accountHolderPrizeStatus;

  public AccountHolderPrizeEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AccountHolderEntity getAccountHolder() {
    return this.accountHolder;
  }

  public void setAccountHolder(AccountHolderEntity accountHolder) {
    this.accountHolder = accountHolder;
  }

  public AccountHolderPrizeStatusEntity getAccountHolderPrizeStatus() {
    return this.accountHolderPrizeStatus;
  }

  public void setAccountHolderPrizeStatus(AccountHolderPrizeStatusEntity accountHolderPrizeStatus) {
    this.accountHolderPrizeStatus = accountHolderPrizeStatus;
  }

}
