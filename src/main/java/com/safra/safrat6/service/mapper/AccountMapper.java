package com.safra.safrat6.service.mapper;

import org.springframework.stereotype.Component;
import com.safra.safrat6.entity.AccountEntity;
import com.safra.safrat6.model.Account;
import com.safra.safrat6.model.User;

@Component
public class AccountMapper {

  public Account toModel(AccountEntity entity) {
    Account account = new Account();
    account.setAgency(entity.getAgencyNumber());
    account.setNumber(entity.getAccountNumber());
    account.setBalance(entity.getBalance().toString());
    User user = new User();
    user.setCpf(entity.getUser().getCpf());
    user.setId(entity.getUser().getId());
    user.setName(entity.getUser().getName());
    account.setUser(user);
    return account;
  }

}
