package fingerprint.manas.edu.kg.controller;

import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.entity.StudentDetail;
import fingerprint.manas.edu.kg.entity.University;
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
    public String showFormForUpdate(@RequestParam("studentId") String theId,
                                    Model theModel) {

        // get the employee from the service
        Student theStudent = studentService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form
        return "students/students-form";
    }


    @RequestMapping("/saves")
    public String saveEmployees(@RequestParam("firstName")String firstName,
                               @RequestParam("lastName")String lastName,
                               @RequestParam("rollNumber")String rollNumber,
                               @RequestParam("email")String email,
                               @RequestParam("grade")String grade,
                               @RequestParam("faculty")String faculty,
                               @RequestParam("department")String department,
                               @RequestParam("image")MultipartFile image) {


        Student theStudent = new Student();
        theStudent.setFirstName(firstName);
        theStudent.setLastName(lastName);
        theStudent.setRollNumber(rollNumber);
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setEmail(email);
        studentDetail.setGrade(Integer.valueOf(grade));
        theStudent.setStudentDetail(studentDetail);
        University university = new University();
        university.setFaculty(faculty);
        university.setDepartment(department);
        theStudent.setUniversity(university);


        studentService.save(theStudent,image);

        // use a redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("student") Student theStudent,
                               @RequestParam("image")MultipartFile image) {


        studentService.save(theStudent,image);

        // use a redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") String theId) {

        // delete the employee
        studentService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/students/list";

    }

}
