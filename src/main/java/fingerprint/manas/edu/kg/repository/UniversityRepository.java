package fingerprint.manas.edu.kg.repository;

import fingerprint.manas.edu.kg.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {
    University findUniversityByFacultyAndDepartment(String faculty,String department);
}
