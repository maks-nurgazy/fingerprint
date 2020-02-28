package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.dto.CourseDto;
import attendance.manas.edu.kg.dto.CourseDtoMapper;
import attendance.manas.edu.kg.entity.Course;
import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.repository.CourseRepository;
import attendance.manas.edu.kg.repository.StudentRepository;
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
public class AdminController {

    TeacherService teacherService;
    CourseRepository courseRepository;
    StudentRepository studentRepository;
    CourseDtoMapper courseDtoMapper;

    @Autowired
    public void setCourseDtoMapper(CourseDtoMapper courseDtoMapper) {
        this.courseDtoMapper = courseDtoMapper;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/showTeacherForm")
    public String addTeacherForm(Model model){

        Teacher teacher = new Teacher();
        model.addAttribute("teacher",teacher);

        return "teachers/teachers-form";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/";
    }


    @GetMapping("/showStudentForm")
    public String addStudentForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);

        return "students/students-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentRepository.save(student);
        return "redirect:/";
    }


    @GetMapping("/showCourseForm")
    public String addCourseForm(Model model){

        CourseDto course = new CourseDto();
        List<String>teachers = teacherService.getFullName();
        model.addAttribute("course",course);
        model.addAttribute("teachers",teachers);
        return "course/course-form";
    }

    @ResponseBody
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") CourseDto courseDTO){
        Course course = courseDtoMapper.convertToEntity(courseDTO);
        courseRepository.save(course);
        return "redirect:/";
    }

}
