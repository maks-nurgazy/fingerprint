package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Course;
import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    CourseService courseService;

    @GetMapping("/list")
    public String showStudents(Model model){
        Course course =  courseService.findByName("Chemistry");
        List<Student> students = course.getStudents();
        model.addAttribute("students",students);
        return "attendance/attendance-list";
    }



    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
