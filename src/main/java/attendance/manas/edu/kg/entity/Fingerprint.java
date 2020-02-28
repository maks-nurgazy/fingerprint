package attendance.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Fingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "student_id")
    private Student student;

    private byte[] sample;

}