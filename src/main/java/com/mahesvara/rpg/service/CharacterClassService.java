package com.mahesvara.rpg.service;

import com.mahesvara.rpg.entity.CharacterClass;
import com.mahesvara.rpg.model.characterclass.CreateCharacterClassRequest;
import com.mahesvara.rpg.repository.CharacterClassRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CharacterClassService {

    @Autowired
    private CharacterClassRepository characterClassRepository;

    @Autowired
    private Validator validator;

    public void create(CreateCharacterClassRequest request) {
        Set<ConstraintViolation<CreateCharacterClassRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        CharacterClass characterClass = new CharacterClass();
        characterClass.setName(request.getName());
        characterClass.setDescription(request.getDescription());
        characterClass.setPrimarySkill(request.getPrimarySkill());
        characterClassRepository.save(characterClass);
    }
}
