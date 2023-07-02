package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Category;
import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.entity.Member;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityListenerTest {

  @Test
  void entity() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Category category = new Category();
    category.setName("Buah-buahan");
    category.setDescription("Berasal dari tumbuh tumbuhan");
    manager.persist(category);

    transaction.commit();

    manager.close();
  }

  @Test
  void listenerEntity() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Member member = manager.find(Member.class, 2);

    Assertions.assertEquals("MR. Ajib Darmawan Sekali", member.getFullName());

    transaction.commit();

    manager.close();
  }
}
