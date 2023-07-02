package belajar.jpa.m19y.entity.inheritance.joinedtable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "payment_gopay")
public class PaymentGopay extends Payment{
  
  @Column(name = "gopay_id")
  private String gopayId;

  public String getGopayId() {
    return gopayId;
  }

  public void setGopayId(String gopayId) {
    this.gopayId = gopayId;
  }
}
