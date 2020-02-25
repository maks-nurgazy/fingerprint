package fingerprint.manas.edu.kg.service;

import org.springframework.web.multipart.MultipartFile;

public interface AttendanceService {

    String isStudentExist(MultipartFile fingerprint);

}
