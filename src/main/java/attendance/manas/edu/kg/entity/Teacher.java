package attendance.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Subject> subjects;

    public void add(Subject subject){
        if(subjects == null){
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
        subject.setTeacher(this);
    }

}
