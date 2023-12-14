package dev.hobie.thymeleaf.dto;

import dev.hobie.thymeleaf.enums.ProjectStatus;

import java.math.BigDecimal;

public record ProjectDTO(
    String name,
    String description,
    ProjectStatus status,
    String clientCompany,
    String leader,
    BigDecimal estimatedBudget,
    BigDecimal totalAmountSpent,
    BigDecimal estimatedProjectDuration) {}
