package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Brand;
import belajar.jpa.m19y.entity.Product;
import belajar.jpa.m19y.entity.User;
import belajar.jpa.m19y.entity.Wallet;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneToManyAndManyToOneMappingTest {

  @Test
  void insertDataOneToOneJoinColumnTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = new Brand();
    brand.setId("samsung");
    brand.setName("Samsung");
    brand.setDescription("mahal nih bos");

    manager.persist(brand);

    Product product1 = new Product();
    product1.setId("p1");
    product1.setBrand(brand);
    product1.setName("Galaxy J1");
    product1.setPrice(1_500_000L);

    manager.persist(product1);

    Product product2 = new Product();
    product2.setId("p2");
    product2.setBrand(brand);
    product2.setName("Galaxy Pro Max");
    product2.setPrice(12_000_000L);
    manager.persist(product2);

    transaction.commit();

    manager.close();
  }

  @Test
  void findDataOneToOneJoinColumnTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Brand brand = manager.find(Brand.class, "samsung");

    Assertions.assertEquals(2, brand.getProducts().size());

    brand.getProducts().forEach(data -> System.out.println(data.getName()));

    transaction.commit();

    manager.close();
  }

  @Test
  void fetchTypeTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Product product = manager.find(Product.class, "p1");

    Assertions.assertNotNull(product.getBrand());
    Assertions.assertEquals("Samsung", product.getBrand().getName());

    transaction.commit();

    manager.close();
  }
}
