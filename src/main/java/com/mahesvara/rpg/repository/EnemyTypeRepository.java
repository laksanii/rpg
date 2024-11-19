package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.EnemyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EnemyTypeRepository extends JpaRepository<EnemyType, String> {
}
