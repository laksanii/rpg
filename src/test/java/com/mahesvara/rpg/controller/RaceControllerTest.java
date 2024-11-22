package com.mahesvara.rpg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.model.race.CreateRaceRequest;
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
class RaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createRaceHuman() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("human");
        mockMvc.perform(post("/api/race").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpectAll(status().isOk()).andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });

                    assertEquals("Race created successfully", response.getData());
                }

        );
    }

    @Test
    void createRaceElf() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("elf");
        mockMvc.perform(post("/api/race").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpectAll(status().isOk()).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Race created successfully", response.getData());
        });
    }

    @Test
    void createRaceDwarf() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("dwarf");
        mockMvc.perform(post("/api/race").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpectAll(status().isOk()).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Race created successfully", response.getData());
        });
    }

    @Test
    void createRaceFurry() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("furry");
        mockMvc.perform(
                post("/api/race")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Race created successfully", response.getData());
        });
    }

    @Test
    void createRaceSpirit() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("spirit");
        mockMvc.perform(
                post("/api/race")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Race created successfully", response.getData());
        });
    }

    @Test
    void createRaceAngel() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("angel");
        mockMvc.perform(
                post("/api/race")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Race created successfully", response.getData());
        });
    }

    @Test
    void createRaceDemon() throws Exception {
        CreateRaceRequest request = new CreateRaceRequest();
        request.setName("demon");
        mockMvc.perform(
                post("/api/race")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Race created successfully", response.getData());
        });
    }
}