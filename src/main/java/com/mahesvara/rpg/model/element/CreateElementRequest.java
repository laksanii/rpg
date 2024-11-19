package com.mahesvara.rpg.model.element;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateElementRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String affinity;

}
