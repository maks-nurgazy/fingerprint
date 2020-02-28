package attendance.manas.edu.kg.repository;

import attendance.manas.edu.kg.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findByFirstNameAndLastName(String firstName,String lastName);
    List<Teacher> findByOrderByFirstNameDesc();
}
