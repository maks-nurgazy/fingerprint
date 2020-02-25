package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(String theId);

    void save(Student theEmployee);

    void save(Student student, MultipartFile file);

    void deleteById(String theId);

}
