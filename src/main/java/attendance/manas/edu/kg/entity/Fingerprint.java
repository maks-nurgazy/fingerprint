package attendance.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Fingerprint {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private byte[] sample;
}