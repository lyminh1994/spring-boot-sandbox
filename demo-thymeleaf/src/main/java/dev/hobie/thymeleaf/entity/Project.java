package dev.hobie.thymeleaf.entity;

import dev.hobie.thymeleaf.enums.ProjectStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {

  @Id @GeneratedValue private Long id;

  private String name;
  private String description;
  private ProjectStatus status;
  private String clientCompany;
  private String leader;
  private BigDecimal estimatedBudget;
  private BigDecimal totalAmountSpent;
  private BigDecimal estimatedProjectDuration;
}
