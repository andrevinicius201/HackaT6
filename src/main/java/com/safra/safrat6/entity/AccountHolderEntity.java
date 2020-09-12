package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "account_holder")
@NamedQuery(name = "AccountHolderEntity.findAll", query = "SELECT a FROM AccountHolderEntity a")
public class AccountHolderEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "ACCOUNT_HOLDER_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_HOLDER_ID_GENERATOR")
  private long id;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "agency_number")
  private String agencyNumber;

  private BigDecimal balance;

  @Column(name = "phone_number")
  private String phoneNumber;

  // bi-directional many-to-one association to AccountHolderPrizeEntity
  @OneToMany(mappedBy = "accountHolder")
  private List<AccountHolderPrizeEntity> accountHolderPrizes;

  // bi-directional many-to-one association to InviteEntity
  @OneToMany(mappedBy = "accountHolder")
  private List<InviteEntity> invites;

  // bi-directional many-to-one association to MovementEntity
  @OneToMany(mappedBy = "accountHolder")
  private List<MovementEntity> movements;

  // bi-directional many-to-one association to StickerAccountHolderEntity
  @OneToMany(mappedBy = "accountHolder")
  private List<StickerAccountHolderEntity> stickerAccountHolders;

  public AccountHolderEntity() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
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

  public List<AccountHolderPrizeEntity> getAccountHolderPrizes() {
    return this.accountHolderPrizes;
  }

  public void setAccountHolderPrizes(List<AccountHolderPrizeEntity> accountHolderPrizes) {
    this.accountHolderPrizes = accountHolderPrizes;
  }

  public AccountHolderPrizeEntity addAccountHolderPrize(
      AccountHolderPrizeEntity accountHolderPrize) {
    getAccountHolderPrizes().add(accountHolderPrize);
    accountHolderPrize.setAccountHolder(this);

    return accountHolderPrize;
  }

  public AccountHolderPrizeEntity removeAccountHolderPrize(
      AccountHolderPrizeEntity accountHolderPrize) {
    getAccountHolderPrizes().remove(accountHolderPrize);
    accountHolderPrize.setAccountHolder(null);

    return accountHolderPrize;
  }

  public List<InviteEntity> getInvites() {
    return this.invites;
  }

  public void setInvites(List<InviteEntity> invites) {
    this.invites = invites;
  }

  public InviteEntity addInvite(InviteEntity invite) {
    getInvites().add(invite);
    invite.setAccountHolder(this);

    return invite;
  }

  public InviteEntity removeInvite(InviteEntity invite) {
    getInvites().remove(invite);
    invite.setAccountHolder(null);

    return invite;
  }

  public List<MovementEntity> getMovements() {
    return this.movements;
  }

  public void setMovements(List<MovementEntity> movements) {
    this.movements = movements;
  }

  public MovementEntity addMovement(MovementEntity movement) {
    getMovements().add(movement);
    movement.setAccountHolder(this);

    return movement;
  }

  public MovementEntity removeMovement(MovementEntity movement) {
    getMovements().remove(movement);
    movement.setAccountHolder(null);

    return movement;
  }

  public List<StickerAccountHolderEntity> getStickerAccountHolders() {
    return this.stickerAccountHolders;
  }

  public void setStickerAccountHolders(List<StickerAccountHolderEntity> stickerAccountHolders) {
    this.stickerAccountHolders = stickerAccountHolders;
  }

  public StickerAccountHolderEntity addStickerAccountHolder(
      StickerAccountHolderEntity stickerAccountHolder) {
    getStickerAccountHolders().add(stickerAccountHolder);
    stickerAccountHolder.setAccountHolder(this);

    return stickerAccountHolder;
  }

  public StickerAccountHolderEntity removeStickerAccountHolder(
      StickerAccountHolderEntity stickerAccountHolder) {
    getStickerAccountHolders().remove(stickerAccountHolder);
    stickerAccountHolder.setAccountHolder(null);

    return stickerAccountHolder;
  }

}
