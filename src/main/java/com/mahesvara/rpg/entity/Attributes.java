package com.mahesvara.rpg.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_attributes")
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "strength")
    private int strength;

    @Column(name = "agility")

    private int agility;
    @Column(name = "intelligence")
    private int intelligence;

    @Column(name = "attack")
    private int attack;

    @Column(name = "armor")
    private int armor;

    @Column(name = "magic_resistance")
    private int magicResistance;

    @Column(name = "health")
    private int health;

    @Column(name = "mana")
    private int mana;

    @OneToOne
    @JoinColumn(name = "character_id")
    private Hero hero;

    @OneToOne
    @JoinColumn(name = "enemy_id")
    private Enemy enemy;

}
