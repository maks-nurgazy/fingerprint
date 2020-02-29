package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.CourseDto;
import attendance.manas.edu.kg.dto.CourseDtoMapper;
import attendance.manas.edu.kg.entity.Course;
import attendance.manas.edu.kg.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    CourseDtoMapper courseDtoMapper;


    @Override
    public void save(CourseDto courseDto) {
        Course course = courseDtoMapper.convertToEntity(courseDto);
        courseRepository.save(course);
    }


    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setCourseDtoMapper(CourseDtoMapper courseDtoMapper) {
        this.courseDtoMapper = courseDtoMapper;
    }

}
