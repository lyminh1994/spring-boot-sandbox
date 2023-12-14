package dev.hobie.thymeleaf.repository;

import dev.hobie.thymeleaf.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  Page<Project> findAll(Pageable pageable);
}
