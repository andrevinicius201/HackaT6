package com.safra.safrat6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.safra.safrat6.entity.AccountEntity;
import com.safra.safrat6.entity.AccountPrizeEntity;
import com.safra.safrat6.entity.PrizeEntity;

public interface AccountPrizeRepository extends JpaRepository<AccountPrizeEntity, Long> {

  AccountPrizeEntity findByAccountAndPrize(AccountEntity account, PrizeEntity prize);

}
