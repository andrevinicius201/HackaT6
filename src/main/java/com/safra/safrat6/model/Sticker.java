package com.safra.safrat6.model;

import java.util.List;

public class Sticker {

  private Long id;
  private List<Account> accounts;
  private Prize prize;
  private Integer rowsQuantity;
  private Integer columnsQuantity;
  private Integer piece;
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
  public Integer getRowsQuantity() {
    return rowsQuantity;
  }
  public void setRowsQuantity(Integer rowsQuantity) {
    this.rowsQuantity = rowsQuantity;
  }
  public Integer getColumnsQuantity() {
    return columnsQuantity;
  }
  public void setColumnsQuantity(Integer columnsQuantity) {
    this.columnsQuantity = columnsQuantity;
  }
  public Integer getPiece() {
    return piece;
  }
  public void setPiece(Integer piece) {
    this.piece = piece;
  }

}
