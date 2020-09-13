package com.safra.safrat6.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safra.safrat6.entity.AccountPrizeEntity;
import com.safra.safrat6.entity.AccountPrizeStatusEntity;
import com.safra.safrat6.entity.PrizeEntity;
import com.safra.safrat6.model.Account;
import com.safra.safrat6.model.Prize;
import com.safra.safrat6.repository.AccountPrizeRepository;
import com.safra.safrat6.repository.AccountRepository;
import com.safra.safrat6.service.mapper.AccountMapper;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private AccountPrizeRepository accountPrizeRepository;

  @Autowired
  private AccountMapper accountMapper;

  public Account getAccount(String id) {
    String agency = id.substring(0, 4);
    String number = id.substring(4, id.length());
    return accountMapper
        .toModel(accountRepository.findByAgencyNumberAndAccountNumber(agency, number));
  }

  public Prize postPrize(String id, Prize prize) {
    AccountPrizeEntity entityToSave = new AccountPrizeEntity();
    entityToSave.setAccount(accountRepository.findByAgencyNumberAndAccountNumber(id.substring(0, 4), id.substring(4, id.length())));
    entityToSave.setPrize(new PrizeEntity(prize.getId()));
    entityToSave.setAccountPrizeStatus(new AccountPrizeStatusEntity(1L));
    accountPrizeRepository.save(entityToSave);
    prize.setAccounts(Arrays.asList(this.getAccount(id)));
    prize.setStatus("Participando");
    return prize;
  }

}
