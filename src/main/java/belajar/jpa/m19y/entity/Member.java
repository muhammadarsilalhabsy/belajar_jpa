package belajar.jpa.m19y.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "members")
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Embedded
  private Name name;
  private String email;

  @Transient
  private String fullName;

  @ElementCollection
  @CollectionTable(name = "skills", joinColumns = @JoinColumn(
          name = "member_id", referencedColumnName = "id"
  ))
  @MapKeyColumn(name = "name")
  @Column(name = "value")
  private Map<String, Integer> skills;

  /*
  @MapKeyColumn(name = "name") <- column keynya pada table (child)
  @Column(name = "value") <- column valuenya pada table (child)
  * */

  @ElementCollection
  @CollectionTable(name = "hobbies", joinColumns = @JoinColumn(
          name = "member_id", referencedColumnName = "id"
  ))
  @Column(name = "name")
  private List<String> hobbies;

/*  @ElementCollection <- deklarasi sebagai element collection
  @CollectionTable(name = "nama-tabelnya(child)", joinColumns = @JoinColumn(
          name = "nama-column-table-relasinya(child)", referencedColumnName = "nama-column-primary-key(parent)"
  ))
  @Column(name = "nama-table yang akan diggunakan")

*/

// post load
  @PostLoad
  public void postLoadFullName(){
    fullName = name.getTitle() + " " + name.getFirstName() + " "
            + name.getMiddleName() + " " + name.getLastName();
  }

//  getter setter =================================================


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Map<String, Integer> getSkills() {
    return skills;
  }

  public void setSkills(Map<String, Integer> skills) {
    this.skills = skills;
  }

  public List<String> getHobbies() {
    return hobbies;
  }

  public void setHobbies(List<String> hobbies) {
    this.hobbies = hobbies;
  }

  public Integer getId() {
    return id;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
