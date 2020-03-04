package attendance.manas.edu.kg.dto;

import attendance.manas.edu.kg.entity.Course;
import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDtoMapperImpl implements CourseDtoMapper{

    TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Course convertToEntity(CourseDto courseDto) {
        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        Teacher teacher = getTeacher(courseDto.getTeacher());
        System.out.println(courseDto.getTeacher());
        course.setTeacher(teacher);
        return course;
    }


    private Teacher getTeacher(String fullName){
        String[] fullData = fullName.split(" ");
        return  teacherRepository.findByFirstNameAndLastName(fullData[0],fullData[1]);
    }

}
