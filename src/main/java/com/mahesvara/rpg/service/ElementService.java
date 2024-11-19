package com.mahesvara.rpg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahesvara.rpg.entity.Element;
import com.mahesvara.rpg.model.element.CreateElementRequest;
import com.mahesvara.rpg.repository.ElementRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private ObjectMapper objectMapper;

    public void create(CreateElementRequest request) {
        Set<ConstraintViolation<CreateElementRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }


        Element element = new Element();
        element.setName(request.getName());
        element.setAffinity(request.getAffinity());
        elementRepository.save(element);
    }

}
