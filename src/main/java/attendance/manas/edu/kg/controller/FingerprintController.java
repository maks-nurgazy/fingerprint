package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class FingerprintController {

    @GetMapping("/showFingerprintForm")
    public String addFingerprintForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);

        return "students/fingerprint-form";
    }



}
