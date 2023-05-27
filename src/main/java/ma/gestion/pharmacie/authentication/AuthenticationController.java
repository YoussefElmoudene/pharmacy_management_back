package ma.gestion.pharmacie.authentication;


import ma.gestion.pharmacie.Service.UserService;
import ma.gestion.pharmacie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserVo userRequest) throws Exception {
		return authenticationService.signIn(userRequest);
	}


}
