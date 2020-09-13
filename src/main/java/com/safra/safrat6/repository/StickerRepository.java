package com.safra.safrat6.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.safra.safrat6.entity.StickerEntity;

@Repository
public interface StickerRepository extends JpaRepository<StickerEntity, Long> {

  @Query("select s from StickerEntity s " + "inner join s.prize as p "
      + "inner join p.accountPrizes as ap " + "inner join ap.account as a "
      + "inner join ap.accountPrizeStatus as aps " + "where aps.id = :status "
      + "and a.agencyNumber = :agencyNumber " + "and a.accountNumber = :accountNumber ")
  List<StickerEntity> findByAccountAndPrizeStatus(@Param("status") Long status,
      @Param("agencyNumber") String agencyNumber, @Param("accountNumber") String accountNumber);

  @Query("select distinct s from StickerEntity s inner join s.prize as p "
      + "inner join p.accountPrizes as ap inner join ap.account as a inner join s.stickerAccounts "
      + "where a.agencyNumber = :agencyNumber and a.accountNumber = :accountNumber "
      + "and p.id = :prizeId")
  List<StickerEntity> findByAccountAndPrizeDistincPieces(@Param("agencyNumber") String agencyNumber,
      @Param("accountNumber") String accountNumber, @Param("prizeId") Long prizeId);

}
