package belajar.jpa.m19y.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends AuditableEntity<String> {

  private String name;

  private String description;

  @OneToMany(mappedBy = "brand")
  private List<Product> products;

  @Version
  private Long version;

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
