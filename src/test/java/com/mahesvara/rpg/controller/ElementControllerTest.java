package com.mahesvara.rpg.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahesvara.rpg.model.WebResponse;
import com.mahesvara.rpg.model.element.CreateElementRequest;
import com.mahesvara.rpg.repository.ElementRepository;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ElementControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private ElementRepository elementRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    void clear(){
//        elementRepository.deleteAll();
//    }

    @Test
    void createSuccessFire() throws Exception {
        CreateElementRequest request = new CreateElementRequest();
        request.setName("fire");

        JSONObject affinity = new JSONObject();
        affinity.put("water", 0.8);
        affinity.put("earth", 1);
        affinity.put("fire", 1);
        affinity.put("wind", 1.5);
        affinity.put("light", 1);
        affinity.put("dark", 1);
        request.setAffinity(affinity.toString());

        mockMvc.perform(
                post("/api/element")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Element created successfully", response.getData());
        });

    }

    @Test
    void createSuccessWater() throws Exception {
        CreateElementRequest request = new CreateElementRequest();
        request.setName("water");

        JSONObject affinity = new JSONObject();
        affinity.put("water", 1);
        affinity.put("earth", 0.8);
        affinity.put("fire", 1.5);
        affinity.put("wind", 1);
        affinity.put("light", 1);
        affinity.put("dark", 1);
        request.setAffinity(affinity.toString());

        mockMvc.perform(
                post("/api/element")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Element created successfully", response.getData());
        });

    }

    @Test
    void createSuccessEarth() throws Exception {
        CreateElementRequest request = new CreateElementRequest();
        request.setName("earth");

        JSONObject affinity = new JSONObject();
        affinity.put("water", 1.5);
        affinity.put("earth", 1);
        affinity.put("fire", 1);
        affinity.put("wind", 0.8);
        affinity.put("light", 1);
        affinity.put("dark", 1);
        request.setAffinity(affinity.toString());

        mockMvc.perform(
                post("/api/element")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Element created successfully", response.getData());
        });

    }

    @Test
    void createSuccessWind() throws Exception {
        CreateElementRequest request = new CreateElementRequest();
        request.setName("wind");

        JSONObject affinity = new JSONObject();
        affinity.put("water", 1);
        affinity.put("earth", 1.5);
        affinity.put("fire", 0.8);
        affinity.put("wind", 1);
        affinity.put("light", 1);
        affinity.put("dark", 1);
        request.setAffinity(affinity.toString());

        mockMvc.perform(
                post("/api/element")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Element created successfully", response.getData());
        });

    }

    @Test
    void createSuccessLight() throws Exception {
        CreateElementRequest request = new CreateElementRequest();
        request.setName("light");

        JSONObject affinity = new JSONObject();
        affinity.put("water", 1);
        affinity.put("earth", 1);
        affinity.put("fire", 1);
        affinity.put("wind", 1);
        affinity.put("light", 1);
        affinity.put("dark", 1.2);
        request.setAffinity(affinity.toString());

        mockMvc.perform(
                post("/api/element")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Element created successfully", response.getData());
        });

    }

    @Test
    void createSuccessDark() throws Exception {
        CreateElementRequest request = new CreateElementRequest();
        request.setName("dark");

        JSONObject affinity = new JSONObject();
        affinity.put("water", 1);
        affinity.put("earth", 1);
        affinity.put("fire", 1);
        affinity.put("wind", 1);
        affinity.put("light", 1.2);
        affinity.put("dark", 1);
        request.setAffinity(affinity.toString());

        mockMvc.perform(
                post("/api/element")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertEquals("Element created successfully", response.getData());
        });

    }



}