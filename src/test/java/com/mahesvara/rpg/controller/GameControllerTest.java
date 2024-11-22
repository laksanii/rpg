package com.mahesvara.rpg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahesvara.rpg.model.RegisterRequest;
import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.repository.HeroRepository;
import com.mahesvara.rpg.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
//    @Autowired
//    private HeroRepository heroRepository;
    @Autowired
    private UserRepository userRepository;

//    @BeforeEach
//    void setUp() {
//        userRepository.deleteAll();
////        heroRepository.deleteAll();
//    }


    void register() throws Exception {
        RegisterRequest request = new RegisterRequest();
        request.setName("Mahesvara");
        request.setWhatsapp("6281234567890");
        request.setCharacterClass("Warrior");
        request.setElement("light");

        mockMvc.perform(
                post("/api/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("User registered successfully", response.getData());
                }
        );
    }

}