package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Race;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RaceRepository extends JpaRepository<Race, String> {
    Race findByName(@NotBlank String race);
}
