package attendance.manas.edu.kg.forms;

import attendance.manas.edu.kg.model.Role;
import lombok.Data;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Role role;
}