package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findByOrderByFirstNameDesc();
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }


    @Override
    public List<String> getFullName(){
        List<Teacher> teachers = findAll();
        List<String> fullName = new ArrayList<>();
        for(Teacher teacher:teachers){
            fullName.add(teacher.getFirstName()+" "+teacher.getLastName());
        }
        return fullName;
    }

}
