package com.mahesvara.rpg.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank
    @Size(max = 20)
    private String whatsapp;

    @NotBlank
    private String name;

    @NotBlank
    private String characterClass;

    @NotBlank
    private String element;

}
