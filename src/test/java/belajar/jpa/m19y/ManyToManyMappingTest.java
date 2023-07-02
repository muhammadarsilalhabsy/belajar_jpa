package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Brand;
import belajar.jpa.m19y.entity.Product;
import belajar.jpa.m19y.entity.User;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class ManyToManyMappingTest {
  @Test
  void inset() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    User user = manager.find(User.class, "arsil");
    user.setLikes(new HashSet<>());

    Product p1 = manager.find(Product.class, "p1");
    Product p2 = manager.find(Product.class, "p2");

    user.getLikes().add(p1);
    user.getLikes().add(p2);


    manager.merge(user);

    transaction.commit();

    Assertions.assertNotNull(user);

    manager.close();
  }

  @Test
  void find() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    User user = manager.find(User.class, "arsil");
    user.getLikes().forEach(product -> System.out.println(product.getName()));

    transaction.commit();

    manager.close();
  }

  @Test
  void Update() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    User user = manager.find(User.class, "arsil");
    Product product = null;

    for (Product item: user.getLikes()) {
      product = item;
      break;
    }

    user.getLikes().remove(product); // hanya menghapus sekali, tidak seperti menggunakan collections
    manager.merge(user);

    transaction.commit();

    manager.close();
  }
}
