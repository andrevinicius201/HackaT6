package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "account_holder_prize_status")
@NamedQuery(name = "AccountHolderPrizeStatusEntity.findAll",
    query = "SELECT a FROM AccountHolderPrizeStatusEntity a")
public class AccountHolderPrizeStatusEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "ACCOUNT_HOLDER_PRIZE_STATUS_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "ACCOUNT_HOLDER_PRIZE_STATUS_ID_GENERATOR")
  private long id;

  private String description;

  // bi-directional many-to-one association to AccountHolderPrizeEntity
  @OneToMany(mappedBy = "accountHolderPrizeStatus")
  private List<AccountHolderPrizeEntity> accountHolderPrizes;

  public AccountHolderPrizeStatusEntity() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<AccountHolderPrizeEntity> getAccountHolderPrizes() {
    return this.accountHolderPrizes;
  }

  public void setAccountHolderPrizes(List<AccountHolderPrizeEntity> accountHolderPrizes) {
    this.accountHolderPrizes = accountHolderPrizes;
  }

  public AccountHolderPrizeEntity addAccountHolderPrize(
      AccountHolderPrizeEntity accountHolderPrize) {
    getAccountHolderPrizes().add(accountHolderPrize);
    accountHolderPrize.setAccountHolderPrizeStatus(this);

    return accountHolderPrize;
  }

  public AccountHolderPrizeEntity removeAccountHolderPrize(
      AccountHolderPrizeEntity accountHolderPrize) {
    getAccountHolderPrizes().remove(accountHolderPrize);
    accountHolderPrize.setAccountHolderPrizeStatus(null);

    return accountHolderPrize;
  }

}
