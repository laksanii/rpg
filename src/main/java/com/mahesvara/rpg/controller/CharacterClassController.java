package com.mahesvara.rpg.controller;

import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.model.characterclass.CreateCharacterClassRequest;
import com.mahesvara.rpg.service.CharacterClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterClassController {

    @Autowired
    private CharacterClassService characterClassService;

    @PostMapping(
            value = "/api/character-class",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> create(@RequestBody CreateCharacterClassRequest request) {
        characterClassService.create(request);
        return WebResponse.<String>builder()
                .data("Character class created successfully")
                .build();
    }
}
