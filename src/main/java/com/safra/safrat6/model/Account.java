package com.safra.safrat6.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

  private Long id;
  private User user;
  private List<Sticker> stickers;
  private List<Prize> prizes;
  private String agency;
  private String number;
  private String balance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Sticker> getStickers() {
    return stickers;
  }

  public void setStickers(List<Sticker> stickers) {
    this.stickers = stickers;
  }

  public List<Prize> getPrizes() {
    return prizes;
  }

  public void setPrizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public String getAgency() {
    return agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

}
