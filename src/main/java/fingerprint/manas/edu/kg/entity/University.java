package fingerprint.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "university")
    private List<Student>students;

}
