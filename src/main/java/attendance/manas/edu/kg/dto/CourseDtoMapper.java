package attendance.manas.edu.kg.dto;

import attendance.manas.edu.kg.entity.Course;

public interface CourseDtoMapper {
    Course convertToEntity(CourseDto courseDTO);
}
