package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "stickers")
@NamedQuery(name = "StickerEntity.findAll", query = "SELECT s FROM StickerEntity s")
public class StickerEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "STICKERS_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STICKERS_ID_GENERATOR")
  private long id;

  @Column(name = "columns_quantity")
  private Integer columnsQuantity;

  private Integer piece;

  @Column(name = "rows_quantity")
  private Integer rowsQuantity;

  // bi-directional many-to-one association to PrizeEntity
  @ManyToOne
  private PrizeEntity prize;

  public StickerEntity() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Integer getColumnsQuantity() {
    return this.columnsQuantity;
  }

  public void setColumnsQuantity(Integer columnsQuantity) {
    this.columnsQuantity = columnsQuantity;
  }

  public Integer getPiece() {
    return this.piece;
  }

  public void setPiece(Integer piece) {
    this.piece = piece;
  }

  public Integer getRowsQuantity() {
    return this.rowsQuantity;
  }

  public void setRowsQuantity(Integer rowsQuantity) {
    this.rowsQuantity = rowsQuantity;
  }

  public PrizeEntity getPrize() {
    return this.prize;
  }

  public void setPrize(PrizeEntity prize) {
    this.prize = prize;
  }

}
