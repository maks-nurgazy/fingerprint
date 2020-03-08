package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Subject;
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
public class SubjectController {

    TeacherService teacherService;
    SubjectService subjectService;

    @GetMapping("/subject-form")
    public String addCourseForm(Model model) {

        Subject subject = new Subject();
        List<Subject>subjects = subjectService.getAllCourses();
        model.addAttribute("subject", subject);
        model.addAttribute("subjects",subjects);

        return "admin/all-subject";
    }


    @PostMapping("/save-subject")
    public String saveCourse(@ModelAttribute("subject") Subject subject) {

        subjectService.save(subject);
        return "redirect:/subject-form";
    }


    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


}
