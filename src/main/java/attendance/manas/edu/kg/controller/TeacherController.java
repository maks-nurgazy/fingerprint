package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.entity.Teacher;
import attendance.manas.edu.kg.service.SubjectService;
import attendance.manas.edu.kg.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {

    TeacherService teacherService;
    SubjectService subjectService;

    @GetMapping("/teacher-form")
    public String addTeacherForm(Model model){

        Teacher teacher = new Teacher();
        List<Subject>subjects = subjectService.getSubjectWithoutTeacher();
        model.addAttribute("teacher",teacher);
        model.addAttribute("subjects",subjects);

        return "admin/add-teacher";
    }

    @PostMapping("/save-teacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/";
    }


    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("allTeacher")
    public String showAllTeacher(){
        return "admin/all-teacher";
    }

    @GetMapping("menu")
    public String showMenu(){
        return "include/menu";
    }

}
