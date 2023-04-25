import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        System.out.println("Запись добавлена в БД.");
    }

   @Override
    public Employee readById(int id, EntityManager entityManager) {
       return entityManager.find(Employee.class, id);
   }

   @Override
    public List<Employee> readAll(EntityManager entityManager) {
       String jpqlQuery = "SELECT s FROM Employee s";
       TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
       List<Employee> employees = query.getResultList();
       return employees;
   }

    @Override
    public void updateById(int id, Employee employee, EntityManager entityManager) {
    }

    @Override
    public void updateById(Employee employee, EntityManager entityManager) {
       entityManager.getTransaction().begin();
       entityManager.merge(employee);
       entityManager.getTransaction().commit();
       System.out.println("Запись изменена!");
   }

    @Override
    public void deleteById(int id, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(readById(id, entityManager));
        } catch (IllegalArgumentException e) {
            System.out.println("Запись с id = " + id + " была удалена из БД.");
            e.printStackTrace();
        }
        entityManager.getTransaction().commit();
    }
}

