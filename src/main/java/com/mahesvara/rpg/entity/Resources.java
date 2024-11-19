package com.mahesvara.rpg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_resources")
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @PositiveOrZero
    @Column(name = "gold")
    private Long gold;

    @Column(name = "experience")
    private Long experience;

    @OneToOne
    @JoinColumn(name = "character_id")
    private Hero hero;
}
