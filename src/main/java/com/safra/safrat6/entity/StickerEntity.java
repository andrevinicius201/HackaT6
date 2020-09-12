package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "stickers")
@NamedQuery(name = "StickerEntity.findAll", query = "SELECT s FROM StickerEntity s")
public class StickerEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "STICKERS_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STICKERS_ID_GENERATOR")
  private Long id;

  private Integer piece;

  // bi-directional many-to-one association to StickerAccountEntity
  @OneToMany(mappedBy = "sticker")
  private List<StickerAccountEntity> stickerAccounts;

  // bi-directional many-to-one association to PrizeEntity
  @ManyToOne
  private PrizeEntity prize;

  public StickerEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPiece() {
    return this.piece;
  }

  public void setPiece(Integer piece) {
    this.piece = piece;
  }

  public List<StickerAccountEntity> getStickerAccounts() {
    return this.stickerAccounts;
  }

  public void setStickerAccounts(List<StickerAccountEntity> stickerAccounts) {
    this.stickerAccounts = stickerAccounts;
  }

  public StickerAccountEntity addStickerAccount(StickerAccountEntity stickerAccount) {
    getStickerAccounts().add(stickerAccount);
    stickerAccount.setSticker(this);

    return stickerAccount;
  }

  public StickerAccountEntity removeStickerAccount(StickerAccountEntity stickerAccount) {
    getStickerAccounts().remove(stickerAccount);
    stickerAccount.setSticker(null);

    return stickerAccount;
  }

  public PrizeEntity getPrize() {
    return this.prize;
  }

  public void setPrize(PrizeEntity prize) {
    this.prize = prize;
  }

}
