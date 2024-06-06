package backend.api;

import backend.model.User;
import backend.model.UserDTO;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
public class UserController {
    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = us.findUserById(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = us.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users.stream().map(UserDTO::new).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User userByEmail = us.findUserByUsernameOrEmail(userDTO.getEmail());
        User userByUsername = us.findUserByUsernameOrEmail(userDTO.getUsername());
        if ((userByUsername != null && !Objects.equals(userByUsername.getId(), id)) || (userByEmail != null && !Objects.equals(userByEmail.getId(), id))|| !isValidEmail(userDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User user = new User(userDTO);
        user = us.updateUser(id, user);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = us.deleteUser(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
