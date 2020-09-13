package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "sticker_account")
@NamedQuery(name = "StickerAccountEntity.findAll", query = "SELECT s FROM StickerAccountEntity s")
public class StickerAccountEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  // bi-directional many-to-one association to AccountEntity
  @ManyToOne
  private AccountEntity account;

  // bi-directional many-to-one association to StickerEntity
  @ManyToOne
  private StickerEntity sticker;

  // bi-directional many-to-one association to TransactionEntity
  @ManyToOne()
  private TransactionEntity transaction;

  public StickerAccountEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AccountEntity getAccount() {
    return this.account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public StickerEntity getSticker() {
    return this.sticker;
  }

  public void setSticker(StickerEntity sticker) {
    this.sticker = sticker;
  }

  public TransactionEntity getTransaction() {
    return this.transaction;
  }

  public void setTransaction(TransactionEntity transaction) {
    this.transaction = transaction;
  }

}
