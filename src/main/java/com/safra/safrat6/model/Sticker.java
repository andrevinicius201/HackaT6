package com.safra.safrat6.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sticker {

  private Long id;
  private List<Account> accounts;
  private Prize prize;
  private Integer piece;

  public Sticker(Integer piece) {
    this.piece = piece;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public Prize getPrize() {
    return prize;
  }

  public void setPrize(Prize prize) {
    this.prize = prize;
  }

  public Integer getPiece() {
    return piece;
  }

  public void setPiece(Integer piece) {
    this.piece = piece;
  }

}
