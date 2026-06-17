package devinfo.projectManagementPlatform.controllers;

import devinfo.projectManagementPlatform.models.User;
import devinfo.projectManagementPlatform.models.dtos.UserResponseDto;
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

    @Autowired
    private final UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/fetchUsers")
    public ResponseEntity<List<UserResponseDto>> listOfUsers() {
        return ResponseEntity.ok(userService.listOfUsers());
    }

    @GetMapping("/fetchUser/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
