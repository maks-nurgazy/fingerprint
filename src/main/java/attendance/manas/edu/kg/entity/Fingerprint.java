package attendance.manas.edu.kg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fingerprint {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "student_id")
    private Student student;

    @Lob
    @Column(columnDefinition = "BLOB NOT NULL")
    private byte[] sample;

    public Fingerprint(byte[] sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return "Fingerprint{" +
                "id=" + id +
                ", sample=" + Arrays.toString(sample) +
                '}';
    }
}