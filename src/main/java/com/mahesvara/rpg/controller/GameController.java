package com.mahesvara.rpg.controller;

import com.mahesvara.rpg.model.RegisterRequest;
import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/api/register",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> register(@RequestBody RegisterRequest request) {
        registerService.register(request);
        return WebResponse.<String>builder()
                .data("User registered successfully")
                .build();
    }

}
