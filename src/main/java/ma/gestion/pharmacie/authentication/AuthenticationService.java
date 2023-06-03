package ma.gestion.pharmacie.authentication;

import lombok.AllArgsConstructor;
import ma.gestion.pharmacie.Repository.UserRepository;
import ma.gestion.pharmacie.entity.User;
import ma.gestion.pharmacie.exception.UserNotFoundException;
import ma.gestion.pharmacie.security.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static ma.gestion.pharmacie.security.filter.JwtConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

@Service
@AllArgsConstructor
public class AuthenticationService {

    public ResponseEntity<?> signIn(UserVo user) throws Exception {
        try {
            System.out.println("user = " + user);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.email, user.password));
        } catch (BadCredentialsException e) {
            System.out.println(e.getMessage());
            throw new UserNotFoundException(e.getMessage());
        }
        System.out.println("user.email = " + user.email);
        User loadUserByUsername = loadUserByUsername(user.email);
        System.out.println("loadUserByUsername.getUsername() = " + loadUserByUsername.getUsername());
        MultiValueMap<String, String> jwtHeader = getJwtHeader(loadUserByUsername);
        return new ResponseEntity<>(loadUserByUsername, jwtHeader, OK);
    }


    MultiValueMap<String, String> getJwtHeader(User user) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(JWT_TOKEN_HEADER, jwtUtil.generateToken(user));
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        String token = jwtUtil.generateToken(user);
        System.out.println("token: " + token);
        headers.add("Authorization", token);
        headers.add(JWT_TOKEN_HEADER, token);
        headers.add("Content-Type", "application/json");
        return headers;
    }


    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        } else {
            return user;
        }
    }


    @Autowired
    private UserRepository userDao;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;


}
