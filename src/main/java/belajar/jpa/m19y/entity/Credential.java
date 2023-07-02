package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credentials")
public class Credential {

  @Id
  private String id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;


  // mappedBy itu harus reference atau sama dengan nama property parrentnya (table users)
  @OneToOne(mappedBy = "credential")
  private User user;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
