import lombok.*;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "city_id")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    private String city_name;
    @OneToMany(mappedBy = "city_name", cascade = CascadeType.ALL)
    private List<Employee> employee;

    public City(String name) {
        city_name = name;
    }

    public City(int id, String name) {
        this.city_id = id;
        city_name = name;
    }
}