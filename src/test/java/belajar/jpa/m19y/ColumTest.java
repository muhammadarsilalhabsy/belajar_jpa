package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class ColumTest {

  @Test
  void create() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Customer customer = new Customer();
    customer.setId("C001");
    customer.setName("Arsil");
    customer.setPrimaryEmail("email@example.com");

    manager.persist(customer); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void transientColumn() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Customer customer = new Customer();
    customer.setId("C004");
    customer.setName("Jamet");
    customer.setPrimaryEmail("met@example.com");
    customer.setFullname("Jamet java metal");

    manager.persist(customer); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }
}
