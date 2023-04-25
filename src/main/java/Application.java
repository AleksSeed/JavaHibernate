import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args)  throws SQLException {
        task();
    }

    public static void task() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myUnitPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
        CityDAOImpl cityDAOImpl = new CityDAOImpl();

        for (Employee employee : employeeDAOImpl.readAll(entityManager)) {
            System.out.println(employee);
        }

        employeeDAOImpl.deleteById(7, entityManager);
        employeeDAOImpl.updateById(4, new Employee("Петрушка", "Сенокосов", "man", 58, null), entityManager);
        employeeDAOImpl.create(new Employee("Василиса", "Премудрова", "Woman", 22, null), entityManager);
        System.out.println(employeeDAOImpl.readById(4, entityManager));


        System.out.println("===================");

        employeeDAOImpl.updateById(4, new Employee("Сашка", "Белый", "man", 32, null), entityManager);

        System.out.println("===================");

        cityDAOImpl.deleteCityById(5, entityManager);
        cityDAOImpl.updateCityById(new City(4, "Санкт-Петербург"), entityManager);
        cityDAOImpl.createCity(new City("Тюмень"), entityManager);
        System.out.println(cityDAOImpl.readCityById(6, entityManager));
        System.out.println("===================");
        cityDAOImpl.updateCityById(new City(3, "Новосибирск"), entityManager);
        System.out.println("===================");

        entityManager.close();
        entityManagerFactory.close();
    }
}