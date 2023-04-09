import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(exclude = {"id"})
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "employee")
 public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    @Column(name = "cityid")
    private int city;

    public Employee(String firstName, String lastName, String gender, Integer age, Integer cityId) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = cityId;
    }
}
