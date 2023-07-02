package belajar.jpa.m19y.entity.inheritance.perclass;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Transaction {

  @Id
  private String id;

  private Long balance;

  @Column(name = "created_at")
  private LocalDate createdAt;

  public String getId() {
    return id;
  }

  public Long getBalance() {
    return balance;
  }

  public void setBalance(Long balance) {
    this.balance = balance;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public void setId(String id) {
    this.id = id;
  }
}
