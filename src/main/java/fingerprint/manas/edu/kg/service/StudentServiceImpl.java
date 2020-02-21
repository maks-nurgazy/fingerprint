package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.dao.StudentDAO;
import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    StudentServiceImpl(StudentDAO theStudentDAO) {
        this.studentDAO = theStudentDAO;
    }


    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    @Transactional
    public Optional<Student> getStudent(String rollNumber) {
        return studentDAO.findById(rollNumber);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public String deleteStudent(Student student) {
        String id = student.getRollNumber();
        studentDAO.delete(student);
        return id + " successfully deleted";
    }
}
