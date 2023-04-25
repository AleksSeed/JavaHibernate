import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public void createCity(City city, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public City readCityById(int id, EntityManager entityManager) {
        return entityManager.find(City.class, id);
        }

    @Override
    public List<City> readAllCity(EntityManager entityManager) {
        String jpqlQuery = "SELECT s FROM City s";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> Cities = query.getResultList();
        return Cities;
    }

    @Override
    public void updateCityById(City city, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();
        }

    @Override
    public void deleteCityById(int id, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(readCityById(id, entityManager));
        } catch (IllegalArgumentException e) {
            System.out.println("The city with id = " + id + " doesn't exist");
            e.printStackTrace();
        }
        entityManager.getTransaction().commit();
    }
}
