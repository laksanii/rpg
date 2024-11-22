package com.mahesvara.rpg.service;

import com.mahesvara.rpg.entity.Race;
import com.mahesvara.rpg.model.race.CreateRaceRequest;
import com.mahesvara.rpg.repository.RaceRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class RaceService {


    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private Validator validator;

    public void create(CreateRaceRequest request){
        Set<ConstraintViolation<CreateRaceRequest>> constraintViolation = validator.validate(request);
        if(!constraintViolation.isEmpty()){
            throw new ConstraintViolationException(constraintViolation);
        }

        Race race = new Race();
        race.setName(request.getName());
        raceRepository.save(race);
    }
}
