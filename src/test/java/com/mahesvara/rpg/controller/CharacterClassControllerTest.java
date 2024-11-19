package com.mahesvara.rpg.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.model.characterclass.CreateCharacterClassRequest;
import com.mahesvara.rpg.repository.CharacterClassRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CharacterClassRepository characterClassRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCharacterClassWarriors() throws Exception {
        CreateCharacterClassRequest request = new CreateCharacterClassRequest();
        request.setName("Warrior");
        request.setDescription("A strong class with close combat as their specialty");
            request.setPrimarySkill("War Cry");
        mockMvc.perform(
                post("/api/character-class")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Character class created successfully", response.getData());
                }
        );
    }

    @Test
    void createCharacterClassTank() throws Exception {
        CreateCharacterClassRequest request = new CreateCharacterClassRequest();
        request.setName("Tank");
        request.setDescription("A class with high defense and health points");
        request.setPrimarySkill("Shield Block");
        mockMvc.perform(
                post("/api/character-class")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Character class created successfully", response.getData());
                }
        );
    }

    @Test
    void createCharacterClassMage() throws Exception {
        CreateCharacterClassRequest request = new CreateCharacterClassRequest();
        request.setName("Mage");
        request.setDescription("A class with powerful magic spells for damage and crowd control");
        request.setPrimarySkill("Fireball");
        mockMvc.perform(
                post("/api/character-class")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Character class created successfully", response.getData());
                }
        );
    }

    @Test
    void createCharacterClassSupport() throws Exception {
        CreateCharacterClassRequest request = new CreateCharacterClassRequest();
        request.setName("Support");
        request.setDescription("A class with healing and buffing/debuffing spells");
        request.setPrimarySkill("Heal");
        mockMvc.perform(
                post("/api/character-class")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Character class created successfully", response.getData());
                }
        );
    }

    @Test
    void createCharacterClassArcher() throws Exception {
        CreateCharacterClassRequest request = new CreateCharacterClassRequest();
        request.setName("Archer");
        request.setDescription("A class with ranged attacks and traps");
        request.setPrimarySkill("Arrow Rain");
        mockMvc.perform(
                post("/api/character-class")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Character class created successfully", response.getData());
                }
        );
    }

    @Test
    void createCharacterClassAssassin() throws Exception {
        CreateCharacterClassRequest request = new CreateCharacterClassRequest();
        request.setName("Assassin");
        request.setDescription("A class with high damage and stealth abilities");
        request.setPrimarySkill("Backstab");
        mockMvc.perform(
                post("/api/character-class")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Character class created successfully", response.getData());
                }
        );
    }
}