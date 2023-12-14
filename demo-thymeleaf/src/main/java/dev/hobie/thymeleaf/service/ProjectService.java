package dev.hobie.thymeleaf.service;

import dev.hobie.thymeleaf.entity.Project;
import dev.hobie.thymeleaf.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Project create(ProjectDTO projectDto);

    Page<Project> getProjects(Pageable pageable);

    Project getProject(Long id);

    Project update(Long id, ProjectDTO projectDto);

    void delete(Long id);
}
