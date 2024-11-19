package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Hero;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface HeroRepository extends JpaRepository<Hero , String> {
    Hero getHeroById(@NotBlank String heroId);
}
