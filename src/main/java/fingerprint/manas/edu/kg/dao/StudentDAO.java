package fingerprint.manas.edu.kg.dao;

import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO  extends JpaRepository<Student,String> {

}
