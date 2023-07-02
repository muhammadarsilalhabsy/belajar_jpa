package belajar.jpa.m19y;

import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityManagerTest {

  @Test
  void create() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory(); // dibuat sekali

    // object untuk melakukan crud
    EntityManager manager = factory.createEntityManager();

    Assertions.assertNotNull(manager);
    // operasi database

    // kalau sudah tidak dipakai -> panggil close
    manager.close();
  }
}
