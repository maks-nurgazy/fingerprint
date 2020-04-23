package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.dto.TeacherDto;
import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.service.SubjectService;
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
public class TeacherController {

    TeacherService teacherService;
    SubjectService subjectService;

    @GetMapping("/teacher-form")
    public String addTeacherForm(Model model) {

        TeacherDto teacher = new TeacherDto();
        List<Subject> subjects = subjectService.getSubjectWithoutTeacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects", subjects);

        return "admin/add-teacher";
    }

    @ResponseBody
    @PostMapping("/save-teacher")
    public TeacherDto saveTeacher(@ModelAttribute("teacher") TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return teacherDto;
        // return "redirect:/";
    }


    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("allTeacher")
    public String showAllTeacher() {
        return "admin/all-teacher";
    }

}
