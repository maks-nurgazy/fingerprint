package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.dto.CourseDto;
import attendance.manas.edu.kg.dto.CourseDtoMapper;
import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;
    CourseDtoMapper courseDtoMapper;


    @Override
    public void save(CourseDto courseDto) {
        Subject subject = courseDtoMapper.convertToEntity(courseDto);
        subjectRepository.save(subject);
    }

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


    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Autowired
    public void setCourseDtoMapper(CourseDtoMapper courseDtoMapper) {
        this.courseDtoMapper = courseDtoMapper;
    }

}
