package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.entity.Student;
import attendance.manas.edu.kg.entity.Subject;
import attendance.manas.edu.kg.entity.User;
import attendance.manas.edu.kg.repository.UsersRepository;
import attendance.manas.edu.kg.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AttendanceController {

    SubjectService subjectService;
    UsersRepository usersRepository;

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/takeAttendance")
    public String showStudents(Model model, Principal principal, String s) {
        String name = principal.getName();
        Optional<User> user = usersRepository.findOneByLogin(name);
        List<Subject> subjects = null;
        if (user.isPresent()) {
            User user1 = user.get();
            subjects = subjectService.getSubjects(user1.getFirstName(), user1.getLastName());
        }

        model.addAttribute("subjects", subjects);

        if (s != null) {
            Subject subject = subjectService.findByName(s);
            List<Student> students = subject.getStudents();
            model.addAttribute("students", students);

        }
        return "admin/attendance-list";
    }

    @GetMapping("/sow")
    public String sow(){
        return "admin/all-class";
    }

}
