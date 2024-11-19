package com.mahesvara.rpg.model.characterclass;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCharacterClassRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String primarySkill;
}
