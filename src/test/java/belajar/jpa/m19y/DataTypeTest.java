package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class DataTypeTest {

  @Test
  void dataType() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Customer customer = new Customer();
    customer.setId("C002");
    customer.setName("Otong");
    customer.setPrimaryEmail("otong@example.com");
    customer.setAge((byte) 21);
    customer.isMarried(true);

    manager.persist(customer); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }
}
