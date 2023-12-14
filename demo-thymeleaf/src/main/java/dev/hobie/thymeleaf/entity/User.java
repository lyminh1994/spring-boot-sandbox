package dev.hobie.thymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id @GeneratedValue private Long id;

  private String fullname;
  private String email;
  @JsonIgnore private String password;
  private LocalDateTime lastLoginTime;

  @OneToMany private Set<Role> roles;

  public User(String fullname, String email, String password, Set<Role> roles) {
    this.fullname = fullname;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }
}
