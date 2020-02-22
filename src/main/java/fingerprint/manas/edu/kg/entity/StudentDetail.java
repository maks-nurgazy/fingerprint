package fingerprint.manas.edu.kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fingerprint")
    private String fingerprint;

    @Column(name = "photo")
    private String photo;

    @Column(name = "grade")
    private Integer grade = null;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "studentDetail",cascade = CascadeType.ALL)
    private Student student;

}
