package backend.api;

import backend.model.User;
import backend.model.User.Role;
import backend.model.UserDTO;
import backend.security.ErrorRes;
import backend.security.JwtUtil;
import backend.security.LoginReq;
import backend.security.LoginRes;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class AuthenticationController {
    private final UserService rs;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(@Lazy AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService rs) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.rs = rs;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(loginReq.getUsername(),
                                    loginReq.getPassword()));
            String username = authentication.getName();
            User user = rs.findUserByUsernameOrEmail(username);
            String email = user.getEmail();
            String token = jwtUtil.createToken(user);
            Boolean isAdmin = user.getRole().equals(Role.ROLE_ADMIN);
            String fullName = user.getFirstName() + " " + user.getLastName();
            LoginRes loginRes = new LoginRes(username, token, isAdmin, email, fullName);
            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            if (userDTO.getUsername() == null || !isValidEmail(userDTO.getEmail()) || userDTO.getPassword() == null) {
                throw new IllegalArgumentException("Username, email, and password must be provided");
            }
            User user = new User(userDTO);
            user.setRole(Role.ROLE_USER);
            if (userDTO.getActive() != null) {
                user.setActive(userDTO.getActive());
            } else {
                user.setActive(true);
            }
            user = rs.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(user));
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
