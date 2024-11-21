package com.mahesvara.rpg.entity;

import com.mahesvara.rpg.enumerate.SkillType;
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

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Hero hero;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "effect", columnDefinition = "jsonb")
    private String effect;

    @Column(name = "cooldown")
    private Integer cooldown;

    @Column(name = "cost_type")
    private String costType;

    @Column(name = "cost")
    private Integer cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "element_id")
    private Element element;

    @Column(name = "skill_type")
    private SkillType type;

}
