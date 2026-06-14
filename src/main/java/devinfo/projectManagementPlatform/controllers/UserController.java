package devinfo.projectManagementPlatform.controllers;

import devinfo.projectManagementPlatform.models.User;
import devinfo.projectManagementPlatform.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
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
