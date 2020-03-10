package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class FingerprintController {

    StudentService studentService;

    @GetMapping("/{id}/add-fingerprint")
    public String fingerprintForm(@PathVariable("id") String rollNumber) {
        return null;
    }


    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
