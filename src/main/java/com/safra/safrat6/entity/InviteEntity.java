package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "invites")
@NamedQuery(name = "InviteEntity.findAll", query = "SELECT i FROM InviteEntity i")
public class InviteEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "INVITES_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVITES_ID_GENERATOR")
  private long id;

  private String description;

  @Column(name = "invitation_date")
  private Timestamp invitationDate;

  @Column(name = "invited_email")
  private String invitedEmail;

  @Column(name = "made_effective")
  private Boolean madeEffective;

  // bi-directional many-to-one association to AccountHolderEntity
  @ManyToOne
  @JoinColumn(name = "account_holder_id")
  private AccountHolderEntity accountHolder;

  public InviteEntity() {}

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getInvitationDate() {
    return this.invitationDate;
  }

  public void setInvitationDate(Timestamp invitationDate) {
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

  public AccountHolderEntity getAccountHolder() {
    return this.accountHolder;
  }

  public void setAccountHolder(AccountHolderEntity accountHolder) {
    this.accountHolder = accountHolder;
  }

}
