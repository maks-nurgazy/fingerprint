package attendance.manas.edu.kg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "attendance", cascade = CascadeType.ALL)
    private List<Record> records;

    public void addRecord(Record record) {
        if (records == null) {
            records = new ArrayList<>();
        }
        records.add(record);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "date='" + date + '\'' +
                '}';
    }
}
