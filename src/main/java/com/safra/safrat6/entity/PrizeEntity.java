package com.safra.safrat6.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "prizes")
@NamedQuery(name = "PrizeEntity.findAll", query = "SELECT p FROM PrizeEntity p")
public class PrizeEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String description;

  private String image;

  private BigDecimal price;

  @Column(name = "columns_quantity")
  private Integer columnsQuantity;

  @Column(name = "rows_quantity")
  private Integer rowsQuantity;

  // bi-directional many-to-one association to StickerEntity
  @OneToMany(mappedBy = "prize", cascade = CascadeType.ALL)
  private List<StickerEntity> stickers;

  public PrizeEntity() {}

  public PrizeEntity(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public List<StickerEntity> getStickers() {
    return this.stickers;
  }

  public void setStickers(List<StickerEntity> stickers) {
    this.stickers = stickers;
  }

  public StickerEntity addSticker(StickerEntity sticker) {
    getStickers().add(sticker);
    sticker.setPrize(this);

    return sticker;
  }

  public StickerEntity removeSticker(StickerEntity sticker) {
    getStickers().remove(sticker);
    sticker.setPrize(null);

    return sticker;
  }

  public Integer getColumnsQuantity() {
    return columnsQuantity;
  }

  public void setColumnsQuantity(Integer columnsQuantity) {
    this.columnsQuantity = columnsQuantity;
  }

  public Integer getRowsQuantity() {
    return rowsQuantity;
  }

  public void setRowsQuantity(Integer rowsQuantity) {
    this.rowsQuantity = rowsQuantity;
  }

}
