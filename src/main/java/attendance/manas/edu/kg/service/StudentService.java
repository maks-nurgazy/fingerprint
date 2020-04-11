package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student>getStudents();
    Student getStudent(String id);
}
