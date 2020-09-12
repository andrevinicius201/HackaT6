package com.safra.safrat6.model;

import java.time.LocalDateTime;

public class Invite {

  private Long id;
  private Account account;
  private LocalDateTime dateInvite;
  private String email;
  private String description;
  private boolean effectice;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public LocalDateTime getDateInvite() {
    return dateInvite;
  }
  public void setDateInvite(LocalDateTime dateInvite) {
    this.dateInvite = dateInvite;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public boolean isEffectice() {
    return effectice;
  }
  public void setEffectice(boolean effectice) {
    this.effectice = effectice;
  }
  public Account getAccount() {
    return account;
  }
  public void setAccount(Account account) {
    this.account = account;
  }

}
