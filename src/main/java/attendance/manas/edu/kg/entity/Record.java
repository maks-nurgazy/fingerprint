package attendance.manas.edu.kg.entity;

import attendance.manas.edu.kg.model.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "roll_number")
    private Student student;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attendance_id")
    private Attendance attendance;

}
