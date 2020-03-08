package attendance.manas.edu.kg.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {
    private String firstName;
    private String LastName;
    private List<Integer> subjects;
}
