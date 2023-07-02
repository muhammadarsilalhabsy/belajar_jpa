package belajar.jpa.m19y.entity.inheritance.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MANAGER")
public class Manager extends Employee{

  @Column(name = "total_employee")
  private Integer totalEmployee;

  public Integer getTotalEmployee() {
    return totalEmployee;
  }

  public void setTotalEmployee(Integer totalEmployee) {
    this.totalEmployee = totalEmployee;
  }
}
