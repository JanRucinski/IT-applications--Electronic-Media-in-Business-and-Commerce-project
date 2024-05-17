package backend.service;

import backend.model.User;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User userDTO) {
        if (userRepository.findUserByUsername(userDTO.getUsername()) == null && userRepository.findUserByEmail(userDTO.getEmail()) == null) {
            User user = userRepository.save(new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPhone()));
            userDTO.setId(user.getId());
            userDTO.setCreatedAt(user.getCreatedAt());
            userDTO.setModifiedAt(user.getModifiedAt());
            return userDTO;
        }
        return null;
    }

    @Override
    public User deleteUser(long id) {
        Optional<User> oc = userRepository.findById(id);
        if (oc.isPresent()) {
            userRepository.deleteById(id);
            return createDTOFromEntity(oc.get());
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<User> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(createDTOFromEntity(user));
        }
        return userDTOs;
    }

    @Override
    public User updateUser(User userDTO) {
        if (userRepository.findUserByUsername(userDTO.getUsername()).getId() == userDTO.getId() && userRepository.findUserByEmail(userDTO.getEmail()).getId() == userDTO.getId()) {
            Optional<User> ou = userRepository.findById(userDTO.getId());
            if (ou.isPresent()) {
                ou.get().setUsername(userDTO.getUsername());
                ou.get().setPassword(userDTO.getPassword());
                ou.get().setEmail(userDTO.getEmail());
                ou.get().setFirstName(userDTO.getFirstName());
                ou.get().setLastName(userDTO.getLastName());
                ou.get().setPhone(userDTO.getPhone());
                ou.get().setModifiedAt(OffsetDateTime.now());
                userRepository.save(ou.get());
                userDTO = createDTOFromEntity(ou.get());
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public User findUserById(long id) {
        Optional<User> oc = userRepository.findById(id);
        return oc.map(this::createDTOFromEntity).orElse(null);
    }

    @Override
    public User findUserByUsernameOrEmail(String input) {
        return userRepository.findUserByUsernameOrEmail(input, input);
    }

    public User createDTOFromEntity(User user) {
        User userDTO = new User();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhone(user.getPhone());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setModifiedAt(user.getModifiedAt());
        return userDTO;
    }
}
