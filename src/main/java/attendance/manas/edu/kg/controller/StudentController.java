package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    @GetMapping("/showStudentForm")
    public String addStudentForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);
        return "students/students-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student,Model model){
        studentService.save(student);
        return "redirect:/";
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
