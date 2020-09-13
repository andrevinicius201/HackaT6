package com.safra.safrat6.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.safra.safrat6.entity.AccountEntity;
import com.safra.safrat6.entity.AccountPrizeEntity;
import com.safra.safrat6.entity.AccountPrizeStatusEntity;
import com.safra.safrat6.entity.PrizeEntity;
import com.safra.safrat6.entity.StickerAccountEntity;
import com.safra.safrat6.entity.StickerEntity;
import com.safra.safrat6.entity.TransactionEntity;
import com.safra.safrat6.model.Account;
import com.safra.safrat6.model.Prize;
import com.safra.safrat6.model.Sticker;
import com.safra.safrat6.model.Transaction;
import com.safra.safrat6.repository.AccountPrizeRepository;
import com.safra.safrat6.repository.AccountRepository;
import com.safra.safrat6.repository.StickerAccountRepository;
import com.safra.safrat6.repository.StickerRepository;
import com.safra.safrat6.repository.TransactionRepository;
import com.safra.safrat6.service.mapper.AccountMapper;
import com.safra.safrat6.service.mapper.PrizeMapper;
import com.safra.safrat6.service.mapper.StickerMapper;
import com.safra.safrat6.service.mapper.TransactionMapper;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private AccountPrizeRepository accountPrizeRepository;

  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  private StickerRepository stickerRepository;

  @Autowired
  private StickerAccountRepository stickerAccountRepository;

  @Autowired
  private AccountMapper accountMapper;

  @Autowired
  private StickerMapper stickerMapper;

  @Autowired
  private PrizeMapper prizeMapper;

  @Autowired
  private TransactionMapper transactionMapper;

  public Account getAccount(String id) {
    String agency = id.substring(0, 4);
    String number = id.substring(4, id.length());
    return accountMapper
        .toModel(accountRepository.findByAgencyNumberAndAccountNumber(agency, number));
  }

  public Prize postPrize(String id, Prize prize) {
    AccountPrizeEntity entityToSave = new AccountPrizeEntity();
    entityToSave.setAccount(accountRepository.findByAgencyNumberAndAccountNumber(id.substring(0, 4),
        id.substring(4, id.length())));
    entityToSave.setPrize(new PrizeEntity(prize.getId()));
    entityToSave.setAccountPrizeStatus(new AccountPrizeStatusEntity(1L));
    accountPrizeRepository.save(entityToSave);
    prize.setAccounts(Arrays.asList(this.getAccount(id)));
    prize.setStatus("Participando");
    return prize;
  }

  public List<Sticker> getStickers(String id) {
    AccountEntity entity = accountRepository.findByAgencyNumberAndAccountNumber(id.substring(0, 4),
        id.substring(4, id.length()));
    List<Sticker> stickers = new ArrayList<>();
    entity.getStickerAccounts().forEach(stickerAccount -> {
      Sticker sticker = stickerMapper.toModel(stickerAccount.getSticker());
      Prize prize = prizeMapper.toModel(stickerAccount.getSticker().getPrize());
      sticker.setPrize(prize);
      stickers.add(sticker);
    });
    return stickers;
  }

  public Transaction postTransaction(String id, Transaction transaction) {
    TransactionEntity entityToSave = transactionMapper.toEntity(transaction);
    AccountEntity accountEntity = accountRepository
        .findByAgencyNumberAndAccountNumber(id.substring(0, 4), id.substring(4, id.length()));
    entityToSave.setAccount(accountEntity);
    transactionRepository.save(entityToSave);
    List<StickerEntity> stickerEntities = stickerRepository.findByAccountAndPrizeStatus(1L,
        id.substring(0, 4), id.substring(4, id.length()));
    Collections.shuffle(stickerEntities);
    List<StickerEntity> stickersChosen =
        stickerEntities.subList(0, transaction.getStickersQuantity());
    stickersChosen.forEach(sticker -> {
      StickerAccountEntity stickerAccountEntity = new StickerAccountEntity();
      stickerAccountEntity.setSticker(sticker);
      stickerAccountEntity.setTransaction(new TransactionEntity(entityToSave.getId()));
      stickerAccountEntity.setAccount(accountEntity);
      stickerAccountRepository.save(stickerAccountEntity);
    });
    List<Sticker> stickers = stickerMapper.toModel(stickersChosen);
    // TODO: notificate via firebase
    return transaction;
  }

}
