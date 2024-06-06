package backend.api;

import backend.model.User;
import backend.model.User.Role;
import backend.model.UserDTO;
import backend.security.ErrorRes;
import backend.security.JwtUtil;
import backend.security.LoginReq;
import backend.security.LoginRes;
import backend.service.UserService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.StyledEditorKit.BoldAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class AuthenticationController {

  private final UserService userservice;
  private final AuthenticationManager authenticationManager;
  private JwtUtil jwtUtil;

  @Autowired
  public AuthenticationController(@Lazy AuthenticationManager authenticationManager,
      JwtUtil jwtUtil, UserService userservice) {
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
    this.userservice = userservice;
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
      User user = userservice.findUserByUsernameOrEmail(username);
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
      User newUser = createUserFromDTO(userDTO);
      return ResponseEntity.ok(newUser);
    } catch (Exception e) {
      ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
  }

  private User createUserFromDTO(UserDTO userDTO) {
    User user = new User();

    if(userDTO.getUsername() == null || !isValidEmail(userDTO.getEmail())|| userDTO.getPassword() == null) {
      throw new IllegalArgumentException("Username, email, and password must be provided");
    }

    user.setUsername(userDTO.getUsername());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());

    if(userDTO.getFirstName() != null) {
      user.setFirstName(userDTO.getFirstName());
    }
    if(userDTO.getLastName() != null) {
      user.setLastName(userDTO.getLastName());
    }

    return userservice.addUser(user);
  }

  private boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(emailRegex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

}
