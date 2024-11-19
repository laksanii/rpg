package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CharacterClassRepository extends JpaRepository<CharacterClass, String> {
    CharacterClass findByName(String name);
}
