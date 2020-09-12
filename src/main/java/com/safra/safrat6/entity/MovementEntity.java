package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "movements")
@NamedQuery(name = "MovementEntity.findAll", query = "SELECT m FROM MovementEntity m")
public class MovementEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "MOVEMENTS_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVEMENTS_ID_GENERATOR")
  private long id;

  private Timestamp date;

  private String description;

  @Column(name = "movement_type")
  private String movementType;

  @Column(name = "quantity_stickers")
  private Integer quantityStickers;

  private BigDecimal value;

  // bi-directional many-to-one association to AccountHolderEntity
  @ManyToOne
  @JoinColumn(name = "account_holder_id")
  private AccountHolderEntity accountHolder;

  // bi-directional many-to-one association to StickerAccountHolderEntity
  @OneToMany(mappedBy = "movement")
  private List<StickerAccountHolderEntity> stickerAccountHolders;

  public MovementEntity() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Timestamp getDate() {
    return this.date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMovementType() {
    return this.movementType;
  }

  public void setMovementType(String movementType) {
    this.movementType = movementType;
  }

  public Integer getQuantityStickers() {
    return this.quantityStickers;
  }

  public void setQuantityStickers(Integer quantityStickers) {
    this.quantityStickers = quantityStickers;
  }

  public BigDecimal getValue() {
    return this.value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public AccountHolderEntity getAccountHolder() {
    return this.accountHolder;
  }

  public void setAccountHolder(AccountHolderEntity accountHolder) {
    this.accountHolder = accountHolder;
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
    stickerAccountHolder.setMovement(this);

    return stickerAccountHolder;
  }

  public StickerAccountHolderEntity removeStickerAccountHolder(
      StickerAccountHolderEntity stickerAccountHolder) {
    getStickerAccountHolders().remove(stickerAccountHolder);
    stickerAccountHolder.setMovement(null);

    return stickerAccountHolder;
  }

}
