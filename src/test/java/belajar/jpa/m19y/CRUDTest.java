package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest {

    private EntityManagerFactory factory;
  @BeforeEach
  void setUp() {
    factory = JpaUtil.getEntityManagerFactory();
  }

  @Test
  void create() {
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();
    Customer customer = new Customer();
    customer.setId("C001");
    customer.setName("Arsil");

    manager.persist(customer); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void read() {
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Customer customer = manager.find(Customer.class, "C001"); // find by id
    assertNotNull(customer);
    assertEquals("C001", customer.getId());
    assertEquals("Arsil", customer.getName());

    transaction.commit();
    manager.close();
  }

  @Test
  void update() {
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    // find customer
    Customer customer = manager.find(Customer.class, "C001");
    customer.setName("Arsil Alhabsy");

    // update entity ke database
    manager.merge(customer);

    // pastikan datanya sudah terupdate
    assertEquals("Arsil Alhabsy", customer.getName());

    transaction.commit();
    manager.close();
  }
  @Test
  void remove() {
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    // find customer
    Customer customer = manager.find(Customer.class, "C001");

    // delete customer from database
    manager.remove(customer);

    transaction.commit();
    manager.close();
  }


}
