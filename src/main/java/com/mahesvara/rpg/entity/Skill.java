package com.mahesvara.rpg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "effect", columnDefinition = "jsonb")
    private String effect;

    @Getter
    @Column(name = "cooldown")
    private Integer cooldown;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "cost_type")
    private String costType;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Hero hero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "element_id")
    private Element element;

}
