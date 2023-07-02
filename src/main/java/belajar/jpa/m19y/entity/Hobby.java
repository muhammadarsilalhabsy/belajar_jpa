package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hobbies")
public class Hobby {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "member_id")
  private Integer memberId;

  private String name;

  public Integer getId() {
    return id;
  }

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
