package com.safra.safrat6.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "accounts")
@NamedQuery(name = "AccountEntity.findAll", query = "SELECT a FROM AccountEntity a")
public class AccountEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "agency_number")
  private String agencyNumber;

  private BigDecimal balance;

  @Column(name = "phone_number")
  private String phoneNumber;

  // bi-directional many-to-one association to AccountPrizeEntity
  @OneToMany(mappedBy = "account")
  private List<AccountPrizeEntity> accountPrizes;

  // bi-directional many-to-one association to UserEntity
  @ManyToOne
  private UserEntity user;

  // bi-directional many-to-one association to InviteEntity
  @OneToMany(mappedBy = "account")
  private List<InviteEntity> invites;

  // bi-directional many-to-one association to StickerAccountEntity
  @OneToMany(mappedBy = "account")
  private List<StickerAccountEntity> stickerAccounts;

  // bi-directional many-to-one association to TransactionEntity
  @OneToMany(mappedBy = "account")
  private List<TransactionEntity> transactions;

  public AccountEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAgencyNumber() {
    return this.agencyNumber;
  }

  public void setAgencyNumber(String agencyNumber) {
    this.agencyNumber = agencyNumber;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<AccountPrizeEntity> getAccountPrizes() {
    return this.accountPrizes;
  }

  public void setAccountPrizes(List<AccountPrizeEntity> accountPrizes) {
    this.accountPrizes = accountPrizes;
  }

  public AccountPrizeEntity addAccountPrize(AccountPrizeEntity accountPrize) {
    getAccountPrizes().add(accountPrize);
    accountPrize.setAccount(this);

    return accountPrize;
  }

  public AccountPrizeEntity removeAccountPrize(AccountPrizeEntity accountPrize) {
    getAccountPrizes().remove(accountPrize);
    accountPrize.setAccount(null);

    return accountPrize;
  }

  public UserEntity getUser() {
    return this.user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public List<InviteEntity> getInvites() {
    return this.invites;
  }

  public void setInvites(List<InviteEntity> invites) {
    this.invites = invites;
  }

  public InviteEntity addInvite(InviteEntity invite) {
    getInvites().add(invite);
    invite.setAccount(this);

    return invite;
  }

  public InviteEntity removeInvite(InviteEntity invite) {
    getInvites().remove(invite);
    invite.setAccount(null);

    return invite;
  }

  public List<StickerAccountEntity> getStickerAccounts() {
    return this.stickerAccounts;
  }

  public void setStickerAccounts(List<StickerAccountEntity> stickerAccounts) {
    this.stickerAccounts = stickerAccounts;
  }

  public StickerAccountEntity addStickerAccount(StickerAccountEntity stickerAccount) {
    getStickerAccounts().add(stickerAccount);
    stickerAccount.setAccount(this);

    return stickerAccount;
  }

  public StickerAccountEntity removeStickerAccount(StickerAccountEntity stickerAccount) {
    getStickerAccounts().remove(stickerAccount);
    stickerAccount.setAccount(null);

    return stickerAccount;
  }

  public List<TransactionEntity> getTransactions() {
    return this.transactions;
  }

  public void setTransactions(List<TransactionEntity> transactions) {
    this.transactions = transactions;
  }

  public TransactionEntity addTransaction(TransactionEntity transaction) {
    getTransactions().add(transaction);
    transaction.setAccount(this);

    return transaction;
  }

  public TransactionEntity removeTransaction(TransactionEntity transaction) {
    getTransactions().remove(transaction);
    transaction.setAccount(null);

    return transaction;
  }

}
