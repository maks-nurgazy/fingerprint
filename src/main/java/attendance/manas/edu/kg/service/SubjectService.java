package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.CourseDto;
import attendance.manas.edu.kg.entity.Subject;

import java.util.List;

public interface SubjectService {
    void save(CourseDto courseDto);
    void save(Subject subject);
    Subject findByName(String name);
    List<Subject>getAllCourses();
}
