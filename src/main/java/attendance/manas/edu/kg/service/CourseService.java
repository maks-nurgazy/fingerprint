package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.CourseDto;
import attendance.manas.edu.kg.entity.Course;

public interface CourseService {
    void save(CourseDto courseDto);
    Course findByName(String name);
}
