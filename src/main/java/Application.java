import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myUnitPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

        /** + CREATE*/
       employeeDAOImpl.create(new Employee("Василиса", "Премудрова", "Woman", 22, 5), entityManager);
        /** + SELECT id*/
       System.out.println(employeeDAOImpl.readById(2, entityManager));
        /** + SELECT all*/
       for (Employee employee : employeeDAOImpl.readAll(entityManager)) { System.out.println(employee); }
        /** + UPDATE*/
       employeeDAOImpl.updateById(4, new Employee("Петрушка", "Сенокосов", "man", 58, 2), entityManager);
        /** + DELETE*/
       employeeDAOImpl.deleteById(5, entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }
}