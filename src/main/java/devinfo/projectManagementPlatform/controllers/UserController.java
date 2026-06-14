package devinfo.projectManagementPlatform.controllers;

import devinfo.projectManagementPlatform.models.User;
import devinfo.projectManagementPlatform.repositories.UserRepository;
import devinfo.projectManagementPlatform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @RequestMapping(path = "/fetchUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "/fetchUser/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userRepository.getById(String.valueOf(id));
    }
}
