package com.mahesvara.rpg.model.character;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterHeroRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String classId;

    @NotBlank
    private String name;

    @NotBlank
    private Integer level;

    @NotBlank
    private String elementId;
}
