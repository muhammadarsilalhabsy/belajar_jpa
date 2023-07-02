package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

  @Id
  private String id;

  private String name;

  private Long price;
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id", referencedColumnName = "id")
  private Brand brand;


  @ManyToMany(mappedBy = "likes")
  private Set<User> likeBy;

  // getter setter


  public Set<User> getLikeBy() {
    return likeBy;
  }

  public void setLikeBy(Set<User> likeBy) {
    this.likeBy = likeBy;
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

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }
}
