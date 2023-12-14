package dev.hobie.thymeleaf.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RegisterDTO(String fullname, @NotBlank String email, @NotBlank String password) {}
