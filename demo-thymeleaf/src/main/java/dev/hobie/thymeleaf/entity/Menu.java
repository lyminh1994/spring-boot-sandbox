package dev.hobie.thymeleaf.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Menu {

  @Id @GeneratedValue private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Menu parent;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<Menu> children;

  private String url;
  private String icon;
  private Integer place;
  private Long roleId;

  public void addChild(Menu child) {
    if (children == null) {
      children = new ArrayList<>();
    }

    children.add(child);
    child.setParent(this);
  }
}
