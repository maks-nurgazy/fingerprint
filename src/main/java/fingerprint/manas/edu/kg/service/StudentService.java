package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.dao.StudentDAO;
import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    StudentService(StudentDAO theStudentDAO){
        this.studentDAO = theStudentDAO;
    }

    @Transactional
    public void save(Student student){
        studentDAO.save(student);
    }

}
