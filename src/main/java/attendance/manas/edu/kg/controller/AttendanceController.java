package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    SubjectService subjectService;

    @GetMapping("/list")
    public String showStudents(Model model){
        Subject subject =  subjectService.findByName("Chemistry");
        List<Student> students = subject.getStudents();
        model.addAttribute("students",students);
        return "attendance/attendance-list";
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
}
