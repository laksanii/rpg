package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AttributesRepository extends JpaRepository<Attributes, String> {
}
