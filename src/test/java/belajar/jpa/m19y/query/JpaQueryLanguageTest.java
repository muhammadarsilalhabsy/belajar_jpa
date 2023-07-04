package belajar.jpa.m19y.query;

import belajar.jpa.m19y.entity.*;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;


public class JpaQueryLanguageTest {

  @Test
  void selectAll() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<Brand> query = manager.createQuery("select b from Brand b", Brand.class);
    List<Brand> brands = query.getResultList();

    for(Brand brand : brands){
      System.out.println(brand.getId() + " : " + brand.getName());
    }


    transaction.commit();

    manager.close();
  }

  @Test
  void whereClause() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<Member> query =
            manager.createQuery(
                    "select m from Member m where m.name.firstName = :firstName and m.name.lastName = :lastName",
                    Member.class);
    query.setParameter("firstName", "Muhammad");
    query.setParameter("lastName", "Alhabsy");

    List<Member> members = query.getResultList();

    for(Member member : members){
      System.out.println(member.getId() + " : " + member.getFullName());
    }


    transaction.commit();

    manager.close();
  }

  @Test
  void joinFetch() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<User> query = manager.createQuery(
            "select u from User u join fetch u.likes p where p.name= :product",
            User.class
    );

    query.setParameter("product", "garpu");
    List<User> users = query.getResultList();

    for (User user: users) {
      System.out.println("User: " + user.getName());
      for (Product product: user.getLikes()) {
        System.out.println("User: " + product.getName());
      }
    }

    Assertions.assertEquals(2,users.size());
    Assertions.assertEquals(users.get(0).getName(), "Arsil Alhabsy");
    Assertions.assertEquals(users.get(1).getName(), "jamal ludin");

    transaction.commit();

    manager.close();
  }

  @Test
  void joinClause() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<Product> query =
            manager.createQuery(
                    "select p from Product p join p.brand b where b.name = :brand",
                    Product.class);

    query.setParameter("brand", "Caliburn");
    List<Product> products = query.getResultList();

    for(Product product : products){
      System.out.println(product.getBrand().getId() +" : "+ product.getName() +" : "+ product.getBrand().getName());
    }

    Assertions.assertEquals(2, products.size());


    transaction.commit();

    manager.close();
  }

  @Test
  void OrderByClause() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<Product> query = manager.createQuery("select p from Product p order by p.price desc", Product.class);
    List<Product> products = query.getResultList();

    for(Product product : products){
      System.out.println(product.getId() + " : " + product.getName());
    }

    Assertions.assertEquals(12000000, products.get(0).getPrice());

    transaction.commit();

    manager.close();
  }

  @Test
  void limitOffset() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<Brand> query = manager.createQuery(
            "select b from Brand b", Brand.class
    );

    query.setFirstResult(10); // limit <?,...> which is skip
    query.setMaxResults(10); // limit <...,?> which is how many data will return

    transaction.commit();

    manager.close();
  }

  @Test
  void namedQuery() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TypedQuery<Brand> query = manager.createNamedQuery("Brand.findAllByName", Brand.class);
    query.setParameter("name", "Yamaha");
    List<Brand> brands = query.getResultList();

    for(Brand brand : brands){
      System.out.println(brand.getName());
    }

    Assertions.assertEquals("Yamaha", brands.get(0).getName());


    transaction.commit();

    manager.close();
  }




}
