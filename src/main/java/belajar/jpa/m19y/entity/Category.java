package belajar.jpa.m19y.entity;

import belajar.jpa.m19y.lisetener.UpdatedAtListener;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "categories")
@EntityListeners({
        UpdatedAtListener.class
})
public class Category implements UpdatedAtAware{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(nullable = false)
  private String name;

  private String description;

  @Temporal(value = TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  private Calendar createdAt; // harus mapping menggunakan @Temporal

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;


  // getter & setter ===========================>


  public Calendar getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Calendar createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getId(){
    return id;
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
}
