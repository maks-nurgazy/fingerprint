package attendance.manas.edu.kg.dto;

import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDtoMapperImpl implements TeacherDtoMapper {

    SubjectRepository subjectRepository;

    @Override
    public List<Subject> getMappedSubjects(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        List<Subject> subjects = subjectRepository.findAllByIdIn(teacherDto.getSubjects());
        for (Subject subject:subjects){
            teacher.add(subject);
        }
        return subjects;
    }


    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

}
