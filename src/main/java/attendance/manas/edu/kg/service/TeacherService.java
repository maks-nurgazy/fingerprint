package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    void save(Teacher teacher);
    List<String> getFullName();
}
