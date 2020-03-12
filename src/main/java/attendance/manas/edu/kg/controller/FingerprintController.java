package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FingerprintController {

    StudentService studentService;

    @GetMapping("/add-fingerprint")
    public String fingerprintForm(@RequestParam(name = "id",required = false) String id,
                                  @RequestParam(name = "file",required = false)MultipartFile file,
                                    Model model) {
        if(file != null){

            model.addAttribute("status","Image keldi");

        }
        return "admin/add-fingerprint";
    }


    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
