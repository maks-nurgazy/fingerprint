package fingerprint.manas.edu.kg.dao;

import fingerprint.manas.edu.kg.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;


    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    public void save(Student student) {
        entityManager.persist(student);
    }

}
