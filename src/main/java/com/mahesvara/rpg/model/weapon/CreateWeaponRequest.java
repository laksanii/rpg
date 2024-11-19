package com.mahesvara.rpg.model.weapon;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateWeaponRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String lore;

    @NotBlank
    private String heroId;

}
