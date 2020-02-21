package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    void save(Student theEmployee);

    void deleteById(int theId);

}
