package com.mahesvara.rpg.service;

import com.mahesvara.rpg.entity.User;
import com.mahesvara.rpg.model.RegisterUserRequest;
import com.mahesvara.rpg.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    public void register(RegisterUserRequest request)  {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        if(userRepository.existsByWhatsapp(request.getWhatsapp())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }

        User user = new User();
        user.setWhatsapp(request.getWhatsapp());
        userRepository.save(user);
    }
}
