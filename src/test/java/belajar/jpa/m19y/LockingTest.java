package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Brand;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class LockingTest {

  @Test
  void optimisticLockingTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = new Brand();
    brand.setId("uwell");
    brand.setName("Caliburn");
    brand.setDescription("pod");
    brand.setUpdatedAt(LocalDateTime.now());
    brand.setCreatedAt(LocalDateTime.now());

    manager.persist(brand);
    Assertions.assertNotNull(brand.getVersion());


    transaction.commit();

    manager.close();
  }

  @Test
  void optimisticLockingDemo1Test() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "xiomi");
    brand.setName("Xiaomi updated demo 1");
    brand.setUpdatedAt(LocalDateTime.now());

    Thread.sleep(100 * 1000L);
    manager.persist(brand);

    transaction.commit();

    manager.close();
  }

  @Test
  void optimisticLockingDemo2Test() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "xiomi");
    brand.setName("Xiaomi updated demo 2");
    brand.setUpdatedAt(LocalDateTime.now());

    manager.persist(brand);

    transaction.commit();

    manager.close();
  }

  @Test
  void pessimisticLockingDemo1Test() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "xiomi", LockModeType.PESSIMISTIC_WRITE);
    brand.setName("Xiaomi updated demo 1");
    brand.setUpdatedAt(LocalDateTime.now());

    Thread.sleep(50 * 1000L);
    manager.persist(brand);

    transaction.commit();

    manager.close();
  }

  @Test
  void pessimisticLockingDemo2Test() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "xiomi", LockModeType.PESSIMISTIC_WRITE);
    brand.setName("Xiaomi updated demo 2");
    brand.setUpdatedAt(LocalDateTime.now());

    manager.persist(brand);

    transaction.commit();

    manager.close();
  }
}
