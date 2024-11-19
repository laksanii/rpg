package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
