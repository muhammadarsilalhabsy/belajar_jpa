package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  private String id;

  private String name;

  @Column(name = "primary_email")
  private String primaryEmail;

  private Byte age;

  private Boolean married;

  @Enumerated(value = EnumType.STRING)
  private CustomerType type;

  @Transient // akan mengabaikan filed ini (tidak akan membuat column ke database)
  private String fullname;

  // getter & setter ===========================>


  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public void setMarried(Boolean married) {
    this.married = married;
  }

  public CustomerType getType() {
    return type;
  }

  public void setType(CustomerType type) {
    this.type = type;
  }

  public Byte getAge() {
    return age;
  }

  public void setAge(Byte age) {
    this.age = age;
  }

  public Boolean getMarried() {
    return married;
  }

  public void isMarried(Boolean married) {
    this.married = married;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrimaryEmail() {
    return primaryEmail;
  }

  public void setPrimaryEmail(String primaryEmail) {
    this.primaryEmail = primaryEmail;
  }
}
