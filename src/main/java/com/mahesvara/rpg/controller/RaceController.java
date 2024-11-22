package com.mahesvara.rpg.controller;

import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.model.race.CreateRaceRequest;
import com.mahesvara.rpg.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceController {

    @Autowired
    private RaceService raceService;

    @PostMapping(
            value = "/api/race",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> create(@RequestBody CreateRaceRequest request){
        raceService.create(request);
        return WebResponse.<String>builder().data("Race created successfully").build();
    }
}
