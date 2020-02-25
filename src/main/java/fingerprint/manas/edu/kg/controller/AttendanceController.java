package fingerprint.manas.edu.kg.controller;

import fingerprint.manas.edu.kg.entity.Student;
import fingerprint.manas.edu.kg.service.AttendanceService;
import fingerprint.manas.edu.kg.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private StudentService studentService;
    private AttendanceService attendanceService;

    public AttendanceController(StudentService studentService,AttendanceService attendanceService) {
        this.studentService = studentService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/fingerprint")
    public String fingerprint(@RequestParam("fingerprint") MultipartFile fingerprint,Model model){

        String status = attendanceService.isStudentExist(fingerprint);
        model.addAttribute("status",status);
        return "attendance/exist";
    }

    @GetMapping("/record")
    public String attendanceList(Model theModel) {

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);

        return "attendance/attendance-list";
    }
}
