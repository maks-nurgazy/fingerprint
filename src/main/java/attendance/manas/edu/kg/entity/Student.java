package attendance.manas.edu.kg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Fingerprint> fingerprints;

    public void addSubject(Subject subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subject.addStudent(this);
        subjects.add(subject);
    }

    public void addFingerprint(Fingerprint fingerprint) {
        if (fingerprints == null) {
            fingerprints = new ArrayList<>();
        }
        fingerprints.add(fingerprint);
    }

}
