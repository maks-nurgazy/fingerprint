package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.model.FingerImage;
import attendance.manas.edu.kg.service.StudentService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class FingerprintController {

    StudentService studentService;


    @Autowired
    private SimpMessageSendingOperations messagingTemplate;




    @GetMapping("/add-fingerprint/{id}")
    public String addFingerprint(@PathVariable("id") String id,HttpServletRequest request) {
        request.getSession().setAttribute("id",id);
        /*
         * Бул жерде АРДУИНОГО(ОТПЕЧАТОК ПАЛЬЦЕВ окууган устройствого) запрос барат.
         * Запрос озуно жогорудагы {id} ни камтыйт.
         * АРДУИНО бизге кайра ошол {id} менен кошо устройстводон окуулган суротту жиберет.
         * АРДУИНО @{/fingerprint/id} деген URL га POST запрос кылып жооп кайтарат.
         *
         * */

        return "admin/chat";
    }

    @GetMapping("/fingerprint/{id}")
    public String saveFingerprints(@PathVariable("id") String id, MultipartFile file) {


        FingerImage fingerImage = new FingerImage();
        try {
            byte[] arr = file.getBytes();
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(file.getBytes(), false)));
            String string = sb.toString();
            fingerImage.setImage(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        messagingTemplate.convertAndSend("/topic/publicChatRoom", fingerImage);
        return "admin/chat";

//        Student student = studentService.getStudent(id);
//        try {
//            byte[] fingerByte = fingerImage.getBytes();
//            Fingerprint fingerprint = new Fingerprint(fingerByte);
//            student.addFingerprint(fingerprint);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        studentService.save(student);
//        return "admin/fingerprints";
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


}
