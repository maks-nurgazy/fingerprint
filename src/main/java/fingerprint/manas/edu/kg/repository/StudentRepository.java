package fingerprint.manas.edu.kg.repository;

import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findAllByOrderByLastNameAsc();
}
