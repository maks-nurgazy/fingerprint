package attendance.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    private String subject;

    @OneToMany(mappedBy = "id")
    private List<Record> records;

}
