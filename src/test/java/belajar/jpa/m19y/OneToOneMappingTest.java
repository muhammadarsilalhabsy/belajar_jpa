package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Credential;
import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.entity.User;
import belajar.jpa.m19y.entity.Wallet;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneToOneMappingTest {

  @Test
  void insertDataOneToOnePrimaryKeyJoinColumn() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    User user = new User();
    user.setId("arsil");
    user.setName("Arsil Alhabsy");

    manager.persist(user);

    Credential credential = new Credential();
    credential.setEmail("arsil@email.com");
    credential.setPassword("rahasia");
    credential.setId("arsil");

    manager.persist(credential);


    transaction.commit();

    manager.close();
  }



  @Test
  void insertDataOneToOneJoinColumnTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    User user = manager.find(User.class, "arsil");

    Wallet wallet = new Wallet();
    wallet.setUser(user);
    wallet.setBalance(1_000_000L);

    manager.persist(wallet);

    transaction.commit();

    manager.close();
  }

  @Test
  void testFindOneToOne() {

    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    User user = manager.find(User.class, "arsil");

    // user dengan credential automatis di join sama JPA

    Assertions.assertNotNull(user.getCredential());
    Assertions.assertEquals("rahasia", user.getCredential().getPassword());
    Assertions.assertEquals("arsil@email.com", user.getCredential().getEmail());

    Assertions.assertNotNull(user.getWallet());
    Assertions.assertEquals(1_000_000L,user.getWallet().getBalance());

    transaction.commit();

    manager.close();
  }
}
