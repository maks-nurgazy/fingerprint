package attendance.manas.edu.kg.service;

import attendance.manas.edu.kg.entity.User;
import attendance.manas.edu.kg.forms.UserForm;
import attendance.manas.edu.kg.model.Role;
import attendance.manas.edu.kg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(userForm.getRole())
                .build();

        usersRepository.save(user);
    }
}