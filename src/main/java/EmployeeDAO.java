import javax.persistence.EntityManager;
import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee, EntityManager entityManager);

    Employee readById(int id, EntityManager entityManager);

    List<Employee> readAll(EntityManager entityManager);

    void updateById(int id, Employee employee, EntityManager entityManager);

    void deleteById(int id, EntityManager entityManager);
}