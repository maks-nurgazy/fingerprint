package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Course;
import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.repository.CourseRepository;
import attendance.manas.edu.kg.repository.StudentRepository;
import attendance.manas.edu.kg.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    TeacherRepository teacherRepository;
    CourseRepository courseRepository;
    StudentRepository studentRepository;


    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
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
        teacherRepository.save(teacher);
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

        Course course = new Course();
        model.addAttribute("course",course);

        return "course/course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course")Course course){
        courseRepository.save(course);
        return "redirect:/";
    }

}
