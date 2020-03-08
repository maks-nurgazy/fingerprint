package attendance.manas.edu.kg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "course_id")
    private Subject subject;

    @OneToMany(mappedBy = "attendance",cascade = CascadeType.ALL)
    private List<Record> records;

    public void addRecord(Record record){
        if(records==null){
            records = new ArrayList<>();
        }
        records.add(record);
    }

}
