package com.mahesvara.rpg.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GameConfiguration {

    public Map<String, Map<String, Integer>> baseAttributes() {
        Map<String, Map<String, Integer>> attributes = new HashMap<>();

        // Warrior
        Map<String, Integer> warrior = Map.of(
                "strength", 10,
                "agility", 5,
                "intelligence", 3,
                "armor", 5,
                "magicResistance", 5,
                "attack", 10,
                "health", 20,
                "mana", 10
        );
        attributes.put("warrior", warrior);

        // Archer
        Map<String, Integer> archer = Map.of(
                "strength", 6,
                "agility", 8,
                "intelligence", 6,
                "armor", 5,
                "magicResistance", 5,
                "attack", 10,
                "health", 16,
                "mana", 12
        );
        attributes.put("archer", archer);

        // Mage
        Map<String, Integer> mage = Map.of(
                "strength", 4,
                "agility", 4,
                "intelligence", 10,
                "armor", 4,
                "magicResistance", 6,
                "attack", 5,
                "health", 15,
                "mana", 20
        );
        attributes.put("mage", mage);

        // Tank
        Map<String, Integer> tank = Map.of(
                "strength", 8,
                "agility", 3,
                "intelligence", 4,
                "armor", 10,
                "magicResistance", 8,
                "attack", 5,
                "health", 25,
                "mana", 80
        );
        attributes.put("tank", tank);

        // Assassin
        Map<String, Integer> assassin = Map.of(
                "strength", 8,
                "agility", 10,
                "intelligence", 5,
                "armor", 5,
                "magicResistance", 5,
                "attack", 5,
                "health", 15,
                "mana", 10
        );
        attributes.put("assassin", assassin);

        // Support
        Map<String, Integer> support = Map.of(
                "strength", 5,
                "agility", 7,
                "intelligence", 5,
                "armor", 5,
                "magicResistance", 8,
                "attack", 5,
                "health", 18,
                "mana", 15
        );
        attributes.put("support", support);

        return attributes;
    }

    public Map<String, Map<String, Integer>> attributesGrowth(){
        Map<String, Map<String, Integer>> attributes = new HashMap<>();

        // Warrior
        Map<String, Integer> warrior = Map.of(
                "strength", 3   ,
                "agility", 1,
                "intelligence", 1,
                "armor", 2,
                "magicResistance", 2,
                "attack", 2,
                "health", 5,
                "mana", 2
        );
        attributes.put("warrior", warrior);

        // Archer
        Map<String, Integer> archer = Map.of(
                "strength", 1,
                "agility", 3,
                "intelligence", 1,
                "armor", 1,
                "magicResistance", 1,
                "attack", 2,
                "health", 3,
                "mana", 2
        );
        attributes.put("archer", archer);

        // Mage
        Map<String, Integer> mage = Map.of(
                "strength", 1,
                "agility", 1,
                "intelligence", 3,
                "armor", 1,
                "magicResistance", 2,
                "attack", 1,
                "health", 3,
                "mana", 5
        );
        attributes.put("mage", mage);

        // Tank
        Map<String, Integer> tank = Map.of(
                "strength", 2,
                "agility", 1,
                "intelligence", 1,
                "armor", 3,
                "magicResistance", 3,
                "attack", 1,
                "health", 8,
                "mana", 1
        );
        attributes.put("tank", tank);

        // Assassin
        Map<String, Integer> assassin = Map.of(
                "strength", 2,
                "agility", 5,
                "intelligence", 1,
                "armor", 1,
                "magicResistance", 1,
                "attack", 2,
                "health", 2,
                "mana", 2
        );
        attributes.put("assassin", assassin);

        // Support
        Map<String, Integer> support = Map.of(
                "strength", 1,
                "agility", 1,
                "intelligence", 2,
                "armor", 1,
                "magicResistance", 2,
                "attack", 2,
                "health", 4,
                "mana", 3
        );
        attributes.put("support", support);

        return attributes;
    }

    public Integer calculateLevelUpExp(int level){
        int baseExp = 100;
        return baseExp * (level ^ 2);
    }
}
