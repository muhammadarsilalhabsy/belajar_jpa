package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Lob // lob = large object (diggunakan untuk maping text, blob dan lain sebagainya)
  private String description;

  @Lob
  private byte[] image;

  // getter & setter ===========================>


  public Integer getId() {
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

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }
}
