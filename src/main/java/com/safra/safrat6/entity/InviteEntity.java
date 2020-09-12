package com.safra.safrat6.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "invites")
@NamedQuery(name = "InviteEntity.findAll", query = "SELECT i FROM InviteEntity i")
public class InviteEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "INVITES_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVITES_ID_GENERATOR")
  private Long id;

  private String description;

  @Column(name = "invitation_date")
  private LocalDateTime invitationDate;

  @Column(name = "invited_email")
  private String invitedEmail;

  @Column(name = "made_effective")
  private Boolean madeEffective;

  // bi-directional many-to-one association to AccountEntity
  @ManyToOne
  private AccountEntity account;

  public InviteEntity() {}

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

  public LocalDateTime getInvitationDate() {
    return this.invitationDate;
  }

  public void setInvitationDate(LocalDateTime invitationDate) {
    this.invitationDate = invitationDate;
  }

  public String getInvitedEmail() {
    return this.invitedEmail;
  }

  public void setInvitedEmail(String invitedEmail) {
    this.invitedEmail = invitedEmail;
  }

  public Boolean getMadeEffective() {
    return this.madeEffective;
  }

  public void setMadeEffective(Boolean madeEffective) {
    this.madeEffective = madeEffective;
  }

  public AccountEntity getAccount() {
    return this.account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

}
