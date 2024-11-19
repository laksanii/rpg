package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElementRepository extends JpaRepository<Element, String> {
    Element findByName(String name);
}
