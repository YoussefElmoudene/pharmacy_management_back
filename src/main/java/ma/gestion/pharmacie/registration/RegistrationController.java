package ma.gestion.pharmacie.registration;

import ma.gestion.pharmacie.Service.UserService;
import ma.gestion.pharmacie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserService userService;

    @PostMapping("/send")
    public ResponseEntity<Object> register(@RequestBody(required = true) User userRequest, HttpServletRequest request)
            throws Exception {

        return new ResponseEntity<>(registrationService.register(userRequest), HttpStatus.CREATED);
    }


}
