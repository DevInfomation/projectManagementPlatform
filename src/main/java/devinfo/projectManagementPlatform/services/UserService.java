package devinfo.projectManagementPlatform.services;

import devinfo.projectManagementPlatform.models.User;
import devinfo.projectManagementPlatform.models.dtos.UserResponseDto;
import devinfo.projectManagementPlatform.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    private void checkTheUser(User user) {
        if (user.getFirstName() == null || user.getFirstName().isBlank()) {
            throw new IllegalArgumentException("Fill in the first name!");
        }

        if (user.getLastName() == null || user.getLastName().isBlank()) {
            throw new IllegalArgumentException("Fill in the last name!");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email must be filled out!");
        }

        if (user.getMobileNumber() == null || user.getMobileNumber().isBlank()) {
            throw new IllegalArgumentException("Fill out the mobile number!");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Fill in your password!");
        }
    }

    public User createUser(User user) {
        checkTheUser(user);

        return userRepository.save(user);
    }

    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNumber()
        );
    }

    public List<UserResponseDto> listOfUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getMobileNumber()
                )).toList();
    }


}
