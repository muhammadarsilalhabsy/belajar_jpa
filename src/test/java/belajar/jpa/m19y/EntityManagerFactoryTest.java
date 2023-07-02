package belajar.jpa.m19y;

import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityManagerFactoryTest {

  @Test
  void create() {
    EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
    Assertions.assertNotNull(entityManagerFactory);
  }
}
