package com.mahesvara.rpg.controller;

import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.model.element.CreateElementRequest;
import com.mahesvara.rpg.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElementController {

    @Autowired
    private ElementService elementService;

    @PostMapping(value = "/api/element",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> create(@RequestBody CreateElementRequest request) {
        elementService.create(request);
        return WebResponse.<String>builder()
                .data("Element created successfully")
                .build();
    }
}
