package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

  @Id
  private String id;

  @Column(nullable = false)
  private String name;

  @OneToOne
  @PrimaryKeyJoinColumn(
          name = "id", // tabel sekarang (users)
          referencedColumnName = "id" // table referensinya (credentials)
  )
  private Credential credential;

  @OneToOne(mappedBy = "user")
  private Wallet wallet;

  @ManyToMany
  @JoinTable(
          name = "users_like_products",
          joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
  )
  private Set<Product> likes;

  // getter setter====================


  public Set<Product> getLikes() {
    return likes;
  }

  public void setLikes(Set<Product> likes) {
    this.likes = likes;
  }

  public Wallet getWallet() {
    return wallet;
  }

  public void setWallet(Wallet wallet) {
    this.wallet = wallet;
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

  public Credential getCredential() {
    return credential;
  }

  public void setCredential(Credential credential) {
    this.credential = credential;
  }
}
