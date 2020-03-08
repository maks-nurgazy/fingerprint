package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.TeacherDto;
import attendance.manas.edu.kg.entity.Subject;

import java.util.List;

public interface SubjectService {
    void save(Subject subject);
    Subject findByName(String name);
    List<Subject>getAllCourses();
    List<Subject> getSubjectWithoutTeacher();
}
