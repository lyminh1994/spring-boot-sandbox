package dev.hobie.thymeleaf.dto;

import java.util.List;

public record MenuDTO(Long id, String name, List<MenuDTO> children, String url, String icon) {}
