package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Member;
import belajar.jpa.m19y.entity.Name;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionTest {

  @Test
  void collectionListTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Name name = new Name();
    name.setTitle("MR.");
    name.setFirstName("Ajib");
    name.setMiddleName("Darmawan");
    name.setLastName("Sekali");


    Member member = new Member();
    member.setEmail("member@example.com");
    member.setName(name); // set namenya ke member

    // set data hobby member (tanpa di persist manual)
    member.setHobbies(new ArrayList<>());
    member.getHobbies().add("Makan");
    member.getHobbies().add("Minum");


    manager.persist(member); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void updateCollectionTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Member member = manager.find(Member.class,2);

    // setiap ada penambahan data di collection, data sebelmnya akan dihapus dan
    // akan dibuat ulang, otomatis primary key nya akan berubah
    member.getHobbies().add("Traveling");

    manager.merge(member); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void collectionMapTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Name name = new Name();
    name.setTitle("MR.");
    name.setFirstName("Ucok");
    name.setMiddleName("bin");
    name.setLastName("Surucok");

    Member member = new Member();
    member.setEmail("cok@example.com");
    member.setName(name); // set namenya ke member

    // set data hobbies member (tanpa di persist manual)
    member.setHobbies(new ArrayList<>());
    member.getHobbies().add("Berenang");
    member.getHobbies().add("Makan");

    // set data skills member (tanpa di persist manual)
    member.setSkills(new HashMap<>());
    member.getSkills().put("Java", 95);
    member.getSkills().put("JavaScript", 35);
    member.getSkills().put("MySql", 73);


    manager.persist(member); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

}
