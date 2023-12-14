package dev.hobie.thymeleaf.service.impl;

import dev.hobie.thymeleaf.entity.Project;
import dev.hobie.thymeleaf.dto.ProjectDTO;
import dev.hobie.thymeleaf.repository.ProjectRepository;
import dev.hobie.thymeleaf.service.ProjectService;
import dev.hobie.thymeleaf.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;

  @Override
  public Project create(ProjectDTO projectDto) {
    var project =
        Project.builder()
            .name(projectDto.name())
            .description(projectDto.description())
            .status(projectDto.status())
            .clientCompany(projectDto.clientCompany())
            .leader(projectDto.leader())
            .estimatedBudget(projectDto.estimatedBudget())
            .totalAmountSpent(projectDto.totalAmountSpent())
            .estimatedProjectDuration(projectDto.estimatedProjectDuration())
            .build();

    return projectRepository.save(project);
  }

  @Override
  public Page<Project> getProjects(Pageable pageable) {
    return projectRepository.findAll(pageable);
  }

  @Override
  public Project getProject(Long id) {
    return projectRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public Project update(Long id, ProjectDTO projectDto) {
    var project = projectRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    project.setName(projectDto.name());
    project.setDescription(projectDto.description());
    project.setStatus(projectDto.status());
    project.setClientCompany(projectDto.clientCompany());
    project.setLeader(projectDto.leader());
    project.setEstimatedBudget(projectDto.estimatedBudget());
    project.setTotalAmountSpent(projectDto.totalAmountSpent());
    project.setEstimatedProjectDuration(projectDto.estimatedProjectDuration());

    return projectRepository.save(project);
  }

  @Override
  public void delete(Long id) {
    var project = projectRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    projectRepository.delete(project);
  }
}
