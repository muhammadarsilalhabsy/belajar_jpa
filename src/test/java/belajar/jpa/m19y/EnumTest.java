package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.entity.CustomerType;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class EnumTest {

  @Test
  void enumTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Customer customer = new Customer();
    customer.setId("C003");
    customer.setName("Ucok");
    customer.setPrimaryEmail("cok@example.com");
    customer.setMarried(false);
    customer.setAge((byte) 10);
    customer.setType(CustomerType.PREMIUM);

    manager.persist(customer); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }
}
