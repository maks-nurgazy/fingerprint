package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.dto.CourseDto;
import attendance.manas.edu.kg.service.CourseService;
import attendance.manas.edu.kg.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseController {

    TeacherService teacherService;
    CourseService courseService;

    @GetMapping("/showCourseForm")
    public String addCourseForm(Model model) {

        CourseDto course = new CourseDto();
        List<String> teachers = teacherService.getFullName();
        model.addAttribute("course", course);
        model.addAttribute("teachers", teachers);
        return "course/course-form";
    }

    @ResponseBody
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") CourseDto courseDTO) {

        courseService.save(courseDTO);
        return "redirect:/";
    }


    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


}
