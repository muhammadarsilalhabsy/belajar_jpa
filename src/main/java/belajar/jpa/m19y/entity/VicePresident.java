package belajar.jpa.m19y.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "VP")
public class VicePresident extends Employee{

  @Column(name = "total_manager")
  private Integer totalManager;

  public Integer getTotalManager() {
    return totalManager;
  }

  public void setTotalManager(Integer totalManager) {
    this.totalManager = totalManager;
  }
}
