package attendance.manas.edu.kg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "admin/login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "login_logout/access-denied";
    }

}
