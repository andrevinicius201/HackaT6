package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "sticker_account_holder")
@NamedQuery(name = "StickerAccountHolderEntity.findAll",
    query = "SELECT s FROM StickerAccountHolderEntity s")
public class StickerAccountHolderEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "STICKER_ACCOUNT_HOLDER_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "STICKER_ACCOUNT_HOLDER_ID_GENERATOR")
  private long id;

  @Column(name = "sticker_id")
  private BigDecimal stickerId;

  // bi-directional many-to-one association to AccountHolderEntity
  @ManyToOne
  @JoinColumn(name = "account_holder_id")
  private AccountHolderEntity accountHolder;

  // bi-directional many-to-one association to MovementEntity
  @ManyToOne
  private MovementEntity movement;

  public StickerAccountHolderEntity() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public BigDecimal getStickerId() {
    return this.stickerId;
  }

  public void setStickerId(BigDecimal stickerId) {
    this.stickerId = stickerId;
  }

  public AccountHolderEntity getAccountHolder() {
    return this.accountHolder;
  }

  public void setAccountHolder(AccountHolderEntity accountHolder) {
    this.accountHolder = accountHolder;
  }

  public MovementEntity getMovement() {
    return this.movement;
  }

  public void setMovement(MovementEntity movement) {
    this.movement = movement;
  }

}
