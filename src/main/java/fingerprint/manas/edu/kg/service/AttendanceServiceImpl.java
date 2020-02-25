package fingerprint.manas.edu.kg.service;

import fingerprint.manas.edu.kg.algo.FingerprintAlgo;
import fingerprint.manas.edu.kg.entity.StudentDetail;
import fingerprint.manas.edu.kg.repository.StudentDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final FingerprintAlgo fingerprintAlgo;
    private StudentDetailRepository studentDetailRepository;

    public AttendanceServiceImpl(FingerprintAlgo fingerprintAlgo,StudentDetailRepository studentDetailRepository) {
        this.fingerprintAlgo = fingerprintAlgo;
        this.studentDetailRepository = studentDetailRepository;
    }


    @Override
    public String isStudentExist(MultipartFile image) {

        List<StudentDetail> studentDetail = studentDetailRepository.findAll();

        Integer id = fingerprintAlgo.find(image,studentDetail);

        if(id!=null)
        {
            return "Present";
        }
        return "Absent";
    }

}
