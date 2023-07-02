package belajar.jpa.m19y.entity.inheritance.perclass;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions_credit")
public class TransactionCredit extends Transaction{

  @Column(name = "credit_amount")
  private Long creditAmount;

  public Long getCreditAmount() {
    return creditAmount;
  }

  public void setCreditAmount(Long creditAmount) {
    this.creditAmount = creditAmount;
  }
}
