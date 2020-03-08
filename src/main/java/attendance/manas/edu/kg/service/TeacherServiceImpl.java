package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.TeacherDto;
import attendance.manas.edu.kg.dto.TeacherDtoMapper;
import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.repository.SubjectRepository;
import attendance.manas.edu.kg.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository;
    SubjectRepository subjectRepository;
    TeacherDtoMapper teacherDtoMapper;

    @Autowired
    public void setTeacherDtoMapper(TeacherDtoMapper teacherDtoMapper) {
        this.teacherDtoMapper = teacherDtoMapper;
    }

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findByOrderByFirstNameDesc();
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }


    @Override
    public void save(TeacherDto teacherDto) {
        List<Subject> subjects = teacherDtoMapper.getMappedSubjects(teacherDto);
        subjectRepository.saveAll(subjects);
    }

}
