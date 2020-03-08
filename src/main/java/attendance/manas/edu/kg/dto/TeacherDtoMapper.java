package attendance.manas.edu.kg.dto;

import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.entity.Teacher;

import java.util.List;

public interface TeacherDtoMapper {
    List<Subject> getMappedSubjects(TeacherDto teacherDTO);
}
