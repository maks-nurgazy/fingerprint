package fingerprint.manas.edu.kg.repository;

import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findAllByOrderByLastNameAsc();
}
