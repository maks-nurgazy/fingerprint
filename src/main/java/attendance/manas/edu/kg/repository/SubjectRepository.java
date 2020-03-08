package attendance.manas.edu.kg.repository;

import attendance.manas.edu.kg.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    Subject findByName(String name);
    Collection<Subject> findByTeacherIsNull();
}
