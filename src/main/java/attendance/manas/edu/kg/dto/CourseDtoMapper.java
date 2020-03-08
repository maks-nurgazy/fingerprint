package attendance.manas.edu.kg.dto;

import attendance.manas.edu.kg.entity.Subject;

public interface CourseDtoMapper {
    Subject convertToEntity(CourseDto courseDTO);
}
