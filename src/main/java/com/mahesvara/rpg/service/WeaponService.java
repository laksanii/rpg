package com.mahesvara.rpg.service;

import com.mahesvara.rpg.entity.Hero;
import com.mahesvara.rpg.entity.Weapon;
import com.mahesvara.rpg.model.weapon.CreateWeaponRequest;
import com.mahesvara.rpg.repository.HeroRepository;
import com.mahesvara.rpg.repository.WeaponRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private Validator validator;

    public void create(CreateWeaponRequest request) {
        Set<ConstraintViolation<CreateWeaponRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        Weapon weapon = new Weapon();
        weapon.setName(request.getName());
        weapon.setLore(request.getLore());
        weapon.setHero(heroRepository.getHeroById(request.getHeroId()));
        weaponRepository.save(weapon);

    }
}
