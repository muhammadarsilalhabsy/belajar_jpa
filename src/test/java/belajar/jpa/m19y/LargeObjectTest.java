package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.entity.Image;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeObjectTest {

  @Test
  void largeObject() throws IOException {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Image image = new Image();
    image.setName("simple web view");
    image.setDescription("belajar slicing");
    byte[] bytes = Files.readAllBytes(Path.of(getClass().getResource("/images/haha.jpeg").getPath()));
    image.setImage(bytes);


    manager.persist(image); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }
}
