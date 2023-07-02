package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Brand;
import belajar.jpa.m19y.entity.Product;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class MappedSupperClassTest {

  @Test
  void insert() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = new Brand();
    brand.setId("xiomi");
    brand.setName("Xiomi");
    brand.setDescription("harga merakyat");
    brand.setUpdatedAt(LocalDateTime.now());
    brand.setCreatedAt(LocalDateTime.now());
    manager.persist(brand);


    transaction.commit();

    manager.close();
  }
}
