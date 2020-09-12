package com.safra.safrat6.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "USERS_ID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ID_GENERATOR")
  private Long id;

  private String cpf;

  private String name;

  // bi-directional many-to-one association to AccountEntity
  @OneToMany(mappedBy = "user")
  private List<AccountEntity> accounts;

  public UserEntity() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AccountEntity> getAccounts() {
    return this.accounts;
  }

  public void setAccounts(List<AccountEntity> accounts) {
    this.accounts = accounts;
  }

  public AccountEntity addAccount(AccountEntity account) {
    getAccounts().add(account);
    account.setUser(this);

    return account;
  }

  public AccountEntity removeAccount(AccountEntity account) {
    getAccounts().remove(account);
    account.setUser(null);

    return account;
  }

}
