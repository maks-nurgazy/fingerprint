package attendance.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    private String rollNumber;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Subject> cours;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private List<Fingerprint>fingerprints;

    public void addCourse(Subject subject){
        if (cours ==null){
            cours = new ArrayList<>();
        }
        cours.add(subject);
    }

}
