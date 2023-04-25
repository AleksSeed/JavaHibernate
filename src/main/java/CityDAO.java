import javax.persistence.EntityManager;
import java.util.List;

public interface CityDAO {
    void createCity(City city, EntityManager entityManager);
    City readCityById(int id, EntityManager entityManager);
    List<City> readAllCity(EntityManager entityManager);
    void updateCityById(City city, EntityManager entityManager);
    void deleteCityById(int id, EntityManager entityManager);
}
