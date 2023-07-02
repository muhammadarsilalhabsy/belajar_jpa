package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Category;
import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratedValueTest {

  @Test
  void testGeneratedId() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Category category = new Category();
    category.setName("Komputer");
    category.setDescription("Komputer termurah");

    manager.persist(category); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    Assertions.assertNotNull(category.getId());

    manager.close();
  }
}
