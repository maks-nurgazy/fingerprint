package fingerprint.manas.edu.kg.controller;

import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);

        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);

        return "students/students-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") String theId,
                                    Model theModel) {

        Student theStudent = studentService.findById(theId);

        theModel.addAttribute("student", theStudent);

        return "students/students-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("student") Student theStudent,
                               @RequestParam("image") MultipartFile image) {

        studentService.save(theStudent, image);

        return "redirect:/students/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") String theId) {
        studentService.deleteById(theId);
        return "redirect:/students/list";

    }

}
