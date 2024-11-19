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
@Table(name = "t_enemy")
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "enemy_type_id")
    private EnemyType enemyType;

    @OneToOne(mappedBy = "enemy")
    private Attributes attributes;

}
