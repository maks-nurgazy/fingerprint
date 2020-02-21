package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository theStudentRepository) {
        this.studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Student theEmployee) {
        studentRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
