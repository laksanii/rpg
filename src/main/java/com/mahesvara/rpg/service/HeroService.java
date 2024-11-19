package com.mahesvara.rpg.service;

import com.mahesvara.rpg.entity.Hero;
import com.mahesvara.rpg.model.character.RegisterHeroRequest;
import com.mahesvara.rpg.repository.HeroRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HeroService {

    @Autowired
    private HeroRepository characterRepository;

    @Autowired
    private Validator validator;

    public void register(RegisterHeroRequest request) {
        Set<ConstraintViolation<RegisterHeroRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }



        Hero hero = new Hero();
        hero.setName(request.getName());
    }
}
