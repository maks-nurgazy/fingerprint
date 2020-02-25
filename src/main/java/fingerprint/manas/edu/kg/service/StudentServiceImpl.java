package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.algo.FingerprintAlgo;
import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.entity.University;
import fingerprint.manas.edu.kg.repository.StudentRepository;
import fingerprint.manas.edu.kg.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private UniversityRepository universityRepository;
    private FingerprintAlgo fingerprintAlgo;

    StudentServiceImpl(StudentRepository theStudentRepository, UniversityRepository universityRepository) {
        this.studentRepository = theStudentRepository;
        this.universityRepository = universityRepository;
    }

    @Autowired
    public void setFingerprintAlgo(FingerprintAlgo fingerprintAlgo){
        this.fingerprintAlgo = fingerprintAlgo;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(String theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Student theStudent) {
        University university = theStudent.getUniversity();
        University exists = universityRepository.findUniversityByFacultyAndDepartment(
                university.getFaculty(),university.getDepartment());
        if(exists!=null){
            theStudent.setUniversity(exists);
        }
        studentRepository.save(theStudent);
    }

    @Override
    public void save(Student theStudent, MultipartFile file) {

        byte[] serialized = fingerprintAlgo.getImageByte(file);

        theStudent.getStudentDetail().setFingerprint(serialized);
        University university = theStudent.getUniversity();
        University exists = universityRepository.findUniversityByFacultyAndDepartment(
                university.getFaculty(),university.getDepartment());
        if(exists!=null){
            theStudent.setUniversity(exists);
        }
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(String theId) {
        studentRepository.deleteById(theId);
    }
}
