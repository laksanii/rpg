package com.mahesvara.rpg.repository;

import com.mahesvara.rpg.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByWhatsapp(@NotBlank @Size(max = 20) String whatsapp);
}
