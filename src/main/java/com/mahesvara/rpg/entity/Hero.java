package com.mahesvara.rpg.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_character")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;


    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    private List<Weapon> weapon;

    @OneToOne(mappedBy = "hero", cascade = CascadeType.ALL)
    private Attributes attributes;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToOne(mappedBy = "hero", cascade = CascadeType.ALL)
    private Resources resources;

}
