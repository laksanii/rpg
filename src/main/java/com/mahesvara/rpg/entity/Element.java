package com.mahesvara.rpg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_element")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "affinity", columnDefinition = "jsonb")
    private String affinity;

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL)
    private List<Hero> hero;

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL)
    private List<Enemy> enemy;

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL)
    private List<Skill> skills;
}
