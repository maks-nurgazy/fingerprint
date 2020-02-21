package fingerprint.manas.edu.kg.controller;

import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        // get employees from db
        List<Student> theStudents = studentService.findAll();

        // add to the spring model
        theModel.addAttribute("students", theStudents);

        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "students/students-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Student theStudent = studentService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form
        return "students/students-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("student") Student theStudent) {

        // save the employee
        studentService.save(theStudent);

        // use a redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {

        // delete the employee
        studentService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/students/list";

    }

}
