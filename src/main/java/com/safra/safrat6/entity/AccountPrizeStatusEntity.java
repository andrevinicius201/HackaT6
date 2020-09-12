package com.safra.safrat6.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="account_prize_status")
@NamedQuery(name="AccountPrizeStatusEntity.findAll", query="SELECT a FROM AccountPrizeStatusEntity a")
public class AccountPrizeStatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String description;

	//bi-directional many-to-one association to AccountPrizeEntity
	@OneToMany(mappedBy="accountPrizeStatus")
	private List<AccountPrizeEntity> accountPrizes;

	public AccountPrizeStatusEntity() {
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

	public List<AccountPrizeEntity> getAccountPrizes() {
		return this.accountPrizes;
	}

	public void setAccountPrizes(List<AccountPrizeEntity> accountPrizes) {
		this.accountPrizes = accountPrizes;
	}

	public AccountPrizeEntity addAccountPrize(AccountPrizeEntity accountPrize) {
		getAccountPrizes().add(accountPrize);
		accountPrize.setAccountPrizeStatus(this);

		return accountPrize;
	}

	public AccountPrizeEntity removeAccountPrize(AccountPrizeEntity accountPrize) {
		getAccountPrizes().remove(accountPrize);
		accountPrize.setAccountPrizeStatus(null);

		return accountPrize;
	}

}