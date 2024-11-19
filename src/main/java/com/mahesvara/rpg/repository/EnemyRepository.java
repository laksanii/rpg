package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EnemyRepository extends JpaRepository<Enemy, String> {
}
