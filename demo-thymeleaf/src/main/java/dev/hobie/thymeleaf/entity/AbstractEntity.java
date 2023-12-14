package dev.hobie.thymeleaf.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractEntity {

  @Version private long version;
  @CreatedDate private LocalDateTime createdAt;
  @CreatedBy private String createdBy;
  @LastModifiedDate private LocalDateTime updateAt;
  @LastModifiedBy private String updateBy;
}
