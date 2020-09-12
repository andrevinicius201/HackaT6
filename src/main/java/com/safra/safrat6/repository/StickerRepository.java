package com.safra.safrat6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safra.safrat6.entity.StickerEntity;

@Repository
public interface StickerRepository extends JpaRepository<StickerEntity, Long> {

}
