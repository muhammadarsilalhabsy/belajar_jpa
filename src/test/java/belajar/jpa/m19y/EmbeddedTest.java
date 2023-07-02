package belajar.jpa.m19y;

import belajar.jpa.m19y.entity.Department;
import belajar.jpa.m19y.entity.DepartmentId;
import belajar.jpa.m19y.entity.Member;
import belajar.jpa.m19y.entity.Name;
import belajar.jpa.m19y.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmbeddedTest {

  @Test
  void embeddedTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Member member = new Member();
    member.setEmail("member@example.com");

    Name name = new Name();
    name.setTitle("MR.");
    name.setFirstName("Muhammad");
    name.setMiddleName("Arsil");
    name.setLastName("Alhabsy");

    member.setName(name); // set namenya ke member

    manager.persist(member); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void embeddedIDTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    Department department = new Department();
    department.setName("Backend");

    DepartmentId departmentId = new DepartmentId();
    departmentId.setDepartmentId("Dep001");
    departmentId.setCompanyId("Com001");
    department.setId(departmentId);

    manager.persist(department); // persist -> insert into atau menyimpan entity ke database
    transaction.commit();

    manager.close();
  }

  @Test
  void findEmbeddedIDTest() {
    EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
    EntityManager manager = factory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    DepartmentId departmentId = new DepartmentId();
    departmentId.setDepartmentId("Dep001");
    departmentId.setCompanyId("Com001");

    Department department = manager.find(Department.class, departmentId);
    Assertions.assertNotNull(department);
    Assertions.assertEquals("Backend",department.getName());

    transaction.commit();

    manager.close();
  }
}
