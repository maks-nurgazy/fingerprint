package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.TeacherDto;
import attendance.manas.edu.kg.dto.TeacherDtoMapper;
import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;


    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public Subject findByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public List<Subject> getAllCourses() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> getSubjectWithoutTeacher() {
        return subjectRepository.findByTeacherIsNull();
    }


    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

}
