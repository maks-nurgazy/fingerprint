package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getStudents();

    void saveStudent(Student student);

    Optional<Student> getStudent(String rollNumber);

    Student updateStudent(Student Student);

    String deleteStudent(Student student);

}
