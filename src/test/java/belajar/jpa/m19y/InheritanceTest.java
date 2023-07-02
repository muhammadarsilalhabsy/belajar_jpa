package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Customer;
import belajar.jpa.m19y.entity.inheritance.joinedtable.Payment;
import belajar.jpa.m19y.entity.inheritance.joinedtable.PaymentCreditCard;
import belajar.jpa.m19y.entity.inheritance.joinedtable.PaymentGopay;
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
  void insertSingleTable() {
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
  void findSingleTable() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Employee employeeCast = manager.find(Employee.class, "v0001");
    Employee employee = manager.find(Employee.class, "e0001");

    VicePresident vp = (VicePresident) employeeCast; // lebih baik menggunakan joined table

    Assertions.assertEquals("Arsil", vp.getName());
    Assertions.assertEquals("Abilal", employee.getName());


    transaction.commit();

    manager.close();
  }

  @Test
  void insertJoinedTable() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    PaymentGopay gopay = new PaymentGopay();

    gopay.setId("go0001");
    gopay.setGopayId("8999910000");
    gopay.setAmount(1_000_000L);
    manager.persist(gopay);

    PaymentCreditCard credit = new PaymentCreditCard();

    credit.setBank("BCA");
    credit.setId("cr0001");
    credit.setAmount(250_000L);
    credit.setMaskedCard("55555-333-4444");
    manager.persist(credit);

    transaction.commit();

    manager.close();
  }

  @Test
  void findJoinedTable() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    PaymentGopay gopay = manager.find(PaymentGopay.class, "go0001");
    Assertions.assertEquals(1_000_000L, gopay.getAmount());

    Payment payment = manager.find(Payment.class, "cr0001");
    PaymentCreditCard creditCard = (PaymentCreditCard) payment; // lebih baik menggunakan single table

    Assertions.assertEquals(250_000L, creditCard.getAmount());


    transaction.commit();

    manager.close();
  }
}
