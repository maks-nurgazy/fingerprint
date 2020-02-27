package attendance.manas.edu.kg.repository;

import attendance.manas.edu.kg.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
    Course findByName(String name);
}
