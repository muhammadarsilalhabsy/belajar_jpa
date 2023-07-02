package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Brand;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ManagedEntityTest {

  @Test
  void inserEntity() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = new Brand(); // ini adalah unmanaged entity
    brand.setId("sendok");
    brand.setName("Sendok Bintang");
    brand.setCreatedAt(LocalDateTime.now());
    brand.setUpdatedAt(LocalDateTime.now());
    manager.persist(brand); // brand akan di transform ke managed entity (entity yang di manage sama jpa)

    brand.setName("Garpu");
    // manager.merge(brand); data akan di update tanpa harus melakukan merge atau persist

    transaction.commit();

    manager.close();
  }

  @Test
  void findEntity() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "sendok");

    brand.setName("Yamaha"); // akan selalu di update
    // manager.merge(brand); data akan di update tanpa harus melakukan merge atau persist

    transaction.commit();

    manager.close();
  }

  @Test
  void findEntityDetach() throws InterruptedException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "sendok"); // managed entity
    manager.detach(brand); // make managed entity to unmanaged entity
    brand.setName("Yamaha"); // akan selalu di update
    // manager.merge(brand); data akan di update tanpa harus melakukan merge atau persist

    transaction.commit();

    manager.close();
  }
}
