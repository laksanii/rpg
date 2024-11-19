package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SkillRepository extends JpaRepository<Skill, String> {
}
