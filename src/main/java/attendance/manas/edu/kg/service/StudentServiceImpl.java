package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
