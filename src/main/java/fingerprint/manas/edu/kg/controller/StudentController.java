package fingerprint.manas.edu.kg.controller;

import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.entity.StudentDetail;
import fingerprint.manas.edu.kg.entity.University;
import fingerprint.manas.edu.kg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String save(Model model){
        Student student = new Student();
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setFingerprint("finger2");
        studentDetail.setEmail("beka@luv2code.com");
        studentDetail.setGrade(3);


        University university = new University();
        university.setFaculty("Engineering");
        university.setDepartment("computer");

        student.setRollNumber("1704.01021");
        student.setFirstName("beka");
        student.setLastName("baltabaev");
        student.setStudentDetail(studentDetail);
        student.setUniversity(university);

        studentService.saveStudent(student);

        model.addAttribute("theDate",new Date());
        return "saved";
    }

}
