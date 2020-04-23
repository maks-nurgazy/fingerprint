package attendance.manas.edu.kg.repository;

import attendance.manas.edu.kg.entity.Fingerprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FingerprintRepository extends JpaRepository<Fingerprint, Integer> {

}
