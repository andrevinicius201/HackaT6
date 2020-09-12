package com.safra.safrat6.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "transactions")
@NamedQuery(name = "TransactionEntity.findAll", query = "SELECT t FROM TransactionEntity t")
public class TransactionEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "TRANSACTIONS_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_ID_GENERATOR")
  private Long id;

  private LocalDateTime date;

  private String description;

  @Column(name = "quantity_stickers")
  private Integer quantityStickers;

  @Column(name = "transaction_type")
  private String transactionType;

  private BigDecimal value;

  // bi-directional many-to-one association to StickerAccountEntity
  @OneToMany(mappedBy = "transaction")
  private List<StickerAccountEntity> stickerAccounts;

  // bi-directional many-to-one association to AccountEntity
  @ManyToOne
  private AccountEntity account;

  public TransactionEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDate() {
    return this.date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getQuantityStickers() {
    return this.quantityStickers;
  }

  public void setQuantityStickers(Integer quantityStickers) {
    this.quantityStickers = quantityStickers;
  }

  public String getTransactionType() {
    return this.transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public BigDecimal getValue() {
    return this.value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public List<StickerAccountEntity> getStickerAccounts() {
    return this.stickerAccounts;
  }

  public void setStickerAccounts(List<StickerAccountEntity> stickerAccounts) {
    this.stickerAccounts = stickerAccounts;
  }

  public StickerAccountEntity addStickerAccount(StickerAccountEntity stickerAccount) {
    getStickerAccounts().add(stickerAccount);
    stickerAccount.setTransaction(this);

    return stickerAccount;
  }

  public StickerAccountEntity removeStickerAccount(StickerAccountEntity stickerAccount) {
    getStickerAccounts().remove(stickerAccount);
    stickerAccount.setTransaction(null);

    return stickerAccount;
  }

  public AccountEntity getAccount() {
    return this.account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

}
