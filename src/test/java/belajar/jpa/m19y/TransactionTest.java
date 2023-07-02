package belajar.jpa.m19y;

import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class TransactionTest {

  @Test
  void testTranscation() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory(); // dibuat sekali

    // object untuk melakukan crud
    EntityManager manager = factory.createEntityManager();

    // transaction
    EntityTransaction transaction = manager.getTransaction();

    try{
      transaction.begin();

      // melakukan operasi dengan database

      transaction.commit();
    }catch (Throwable throwable){
      transaction.rollback(); // kalau error di rollback
    }


    manager.close();


  }
}
