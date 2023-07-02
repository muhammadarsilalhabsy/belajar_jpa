package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.entity.inheritance.singletable.Employee;
import belajar.jpa.m19y.entity.inheritance.singletable.Manager;
import belajar.jpa.m19y.entity.inheritance.singletable.VicePresident;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InheritanceTest {
  @Test
  void transientColumn() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Employee employee = new Employee();
    employee.setName("Abilal");
    employee.setId("e0001");
    manager.persist(employee);

    Manager man = new Manager();
    man.setId("m0001");
    man.setName("Ajieb");
    man.setTotalEmployee(13);
    manager.persist(man);

    VicePresident vp = new VicePresident();
    vp.setId("v0001");
    vp.setName("Arsil");
    vp.setTotalManager(21);
    manager.persist(vp);

    transaction.commit();

    manager.close();
  }

  @Test
  void find() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Employee employee = manager.find(Employee.class, "v0001");

    VicePresident vp = (VicePresident) employee;

    Assertions.assertEquals("Arsil", vp.getName());


    transaction.commit();

    manager.close();
  }
}
