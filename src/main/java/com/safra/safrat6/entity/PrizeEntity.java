package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "prizes")
@NamedQuery(name = "PrizeEntity.findAll", query = "SELECT p FROM PrizeEntity p")
public class PrizeEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "PRIZES_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIZES_ID_GENERATOR")
  private Long id;

  private String description;

  private String image;

  private BigDecimal price;

  // bi-directional many-to-one association to StickerEntity
  @OneToMany(mappedBy = "prize")
  private List<StickerEntity> stickers;

  public PrizeEntity() {}

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

}
