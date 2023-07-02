package belajar.jpa.m19y.entity.inheritance.joinedtable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_credit_card")
public class PaymentCreditCard extends Payment{

  @Column(name = "masked_card")
  private String maskedCard;

  private String bank;

  public String getMaskedCard() {
    return maskedCard;
  }

  public void setMaskedCard(String maskedCard) {
    this.maskedCard = maskedCard;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }
}
