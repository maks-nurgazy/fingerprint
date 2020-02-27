package attendance.manas.edu.kg.entity;

import attendance.manas.edu.kg.model.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Record {

    @Id
    int id;

    String rollNumber;

    @Enumerated(value = EnumType.STRING)
    Status status;
}
