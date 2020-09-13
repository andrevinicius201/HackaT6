package com.safra.safrat6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.safra.safrat6.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
  
  AccountEntity findByAgencyNumberAndAccountNumber(String agencyNumber, String accountNumber);

}
