package ma.gestion.pharmacie.registration;

import lombok.AllArgsConstructor;
import ma.gestion.pharmacie.Service.RoleService;
import ma.gestion.pharmacie.Service.UserService;
import ma.gestion.pharmacie.entity.Role;
import ma.gestion.pharmacie.entity.User;
import ma.gestion.pharmacie.exception.RequiredParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static ma.gestion.pharmacie.security.filter.RoleConstant.ROLE_ADMIN;

@AllArgsConstructor
@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    public User register(User userRequest) throws Exception {

        // check if the email is not null
        if (userRequest.getEmail() == null) {
            throw new RequiredParameterException("not found");
        }

        // check if the password is not null
        if (userRequest.getPassword() == null) {
            throw new RequiredParameterException("not found");
        }

        // TODO: encrypt the password
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        // TODO: set the old password with the encoded one
        userRequest.setPassword(encodedPassword);

        // TODO: get admin profile
        Role role = roleService.findByNom(ROLE_ADMIN);

        // add profile to user
        userRequest.setRole(ROLE_ADMIN);
        userRequest.setAuthorities(Arrays.asList(role));
        // TODO: save the user
        return userService.save(userRequest);
    }

}
