package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Category;
import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTest {
  @Test
  void dateAndTimeTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Category category = new Category();
    category.setName("Makanan");
    category.setDescription("Sesuatu yang bisa di makan");
    category.setCreatedAt(Calendar.getInstance());
    category.setUpdatedAt(LocalDateTime.now());

    manager.persist(category); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void dateAndTimeUpdateTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Category category = manager.find(Category.class, "2");
    category.setName("Minuman");
    category.setDescription("Sesuatu yang bisa di telan");
    category.setUpdatedAt(LocalDateTime.now());

    manager.merge(category); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }
}
