package attendance.manas.edu.kg.dto;

import attendance.manas.edu.kg.entity.Subject;
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
    public Subject convertToEntity(CourseDto courseDto) {
        Subject subject = new Subject();
        subject.setCode(courseDto.getCode());
        subject.setName(courseDto.getName());
        Teacher teacher = getTeacher(courseDto.getTeacher());
        System.out.println(courseDto.getTeacher());
        subject.setTeacher(teacher);
        return subject;
    }


    private Teacher getTeacher(String fullName){
        String[] fullData = fullName.split(" ");
        return  teacherRepository.findByFirstNameAndLastName(fullData[0],fullData[1]);
    }
}
