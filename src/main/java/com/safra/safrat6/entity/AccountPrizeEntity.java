package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "account_prize")
@NamedQuery(name = "AccountPrizeEntity.findAll", query = "SELECT a FROM AccountPrizeEntity a")
public class AccountPrizeEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  // bi-directional many-to-one association to AccountPrizeStatusEntity
  @ManyToOne
  @JoinColumn(name = "account_prize_status_id")
  private AccountPrizeStatusEntity accountPrizeStatus;

  // bi-directional many-to-one association to AccountEntity
  @ManyToOne
  private AccountEntity account;

  @ManyToOne
  private PrizeEntity prize;

  public AccountPrizeEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AccountPrizeStatusEntity getAccountPrizeStatus() {
    return this.accountPrizeStatus;
  }

  public void setAccountPrizeStatus(AccountPrizeStatusEntity accountPrizeStatus) {
    this.accountPrizeStatus = accountPrizeStatus;
  }

  public AccountEntity getAccount() {
    return this.account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public PrizeEntity getPrize() {
    return prize;
  }

  public void setPrize(PrizeEntity prize) {
    this.prize = prize;
  }

}
