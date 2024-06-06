package backend.api;

import backend.model.User;
import backend.model.UserDTO;
import backend.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class UserController {

  private final UserService us;

  @Autowired
  public UserController(UserService us) {
    this.us = us;
  }

  @GetMapping
  public ResponseEntity<List<UserDTO>> getUsers() {
    List<User> users = us.findAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(users.stream().map(UserDTO::new).collect(Collectors.toList()));
  }

}
