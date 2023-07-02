package belajar.jpa.m19y.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

  @EmbeddedId
  private DepartmentId id;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DepartmentId getId() {
    return id;
  }

  public void setId(DepartmentId id) {
    this.id = id;
  }
}
