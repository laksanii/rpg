package com.mahesvara.rpg.service;

import com.mahesvara.rpg.config.GameConfiguration;
import com.mahesvara.rpg.entity.*;
import com.mahesvara.rpg.model.RegisterRequest;
import com.mahesvara.rpg.repository.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RegisterService {

    private final GameConfiguration gameConfiguration;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterClassRepository characterClassRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private ResourcesRepository resourcesRepository;
    @Autowired
    private AttributesRepository attributesRepository;
    private final InventoryRepository inventoryRepository;
    @Autowired
    private RaceRepository raceRepository;

    public RegisterService(GameConfiguration gameConfiguration,
                           InventoryRepository inventoryRepository) {
        this.gameConfiguration = gameConfiguration;
        this.inventoryRepository = inventoryRepository;
    }

    public void register(RegisterRequest request) {
        Set<ConstraintViolation<RegisterRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }


        if(userRepository.existsByWhatsapp(request.getWhatsapp())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }

        CharacterClass characterClass = characterClassRepository.findByName(request.getCharacterClass());

        Element element = elementRepository.findByName(request.getElement());

        Race race = raceRepository.findByName(request.getRace());

        // Save User
        User user = new User();
        user.setWhatsapp(request.getWhatsapp());
        userRepository.save(user);

        // Create hero
        Hero hero = new Hero();
        hero.setName(request.getName());
        hero.setCharacterClass(characterClass);
        hero.setElement(element);
        hero.setLevel(1);
        hero.setRace(race);
        hero.setUser(user);
        heroRepository.save(hero);

        // create resources
        Resources resources = new Resources();
        resources.setHero(hero);
        resources.setGold(1000L);
        resources.setExperience(0L);
        resourcesRepository.save(resources);

        // Create attributes
        Map<String, Integer> baseAttributes = gameConfiguration.baseAttributes().get(request.getCharacterClass().toLowerCase());

        Attributes attributes = new Attributes();
        attributes.setHero(hero);
        attributes.setStrength(baseAttributes.get("strength"));
        attributes.setAgility(baseAttributes.get("agility"));
        attributes.setIntelligence(baseAttributes.get("intelligence"));
        attributes.setArmor(baseAttributes.get("armor"));
        attributes.setMagicResistance(baseAttributes.get("magicResistance"));
        attributes.setAttack(baseAttributes.get("attack"));
        attributes.setHealth(baseAttributes.get("health"));
        attributes.setMana(baseAttributes.get("mana"));
        attributesRepository.save(attributes);

        // Create inventory
        Inventory inventory = new Inventory();
        inventory.setHero(hero);
        inventoryRepository.save(inventory);


    }

}
