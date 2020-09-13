package com.safra.safrat6.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.safra.safrat6.entity.AccountEntity;
import com.safra.safrat6.entity.InviteEntity;

public interface InviteRepository extends JpaRepository<InviteEntity, Long> {

  List<InviteEntity> findByAccount(AccountEntity accountEntity);


}
