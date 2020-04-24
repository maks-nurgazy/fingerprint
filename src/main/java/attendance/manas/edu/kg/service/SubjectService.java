package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.entity.Subject;

import java.util.List;

public interface SubjectService {
    void save(Subject subject);

    Subject findByName(String name);

    List<Subject> getAllCourses();

    List<Subject> getSubjectWithoutTeacher();

    List<Subject>getSubjects(String f,String l);

}
