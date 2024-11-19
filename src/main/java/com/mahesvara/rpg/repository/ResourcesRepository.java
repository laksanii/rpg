package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ResourcesRepository extends JpaRepository<Resources, String> {
}
