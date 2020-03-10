package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    StudentService studentService;

    @GetMapping("/student-form")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "admin/add-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student-form";
    }

    @GetMapping("/all-student")
    public String allStudent(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "admin/all-student";
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
