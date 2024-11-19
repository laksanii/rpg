package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface WeaponRepository extends JpaRepository<Weapon, String> {
    Weapon getWeaponByName(String name);
}
