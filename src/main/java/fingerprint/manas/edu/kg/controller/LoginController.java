package fingerprint.manas.edu.kg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login-logout/plain-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "login-logout/access-denied";
    }

}
