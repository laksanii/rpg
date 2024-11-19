package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ItemRepository extends JpaRepository<Item, String> {
}
