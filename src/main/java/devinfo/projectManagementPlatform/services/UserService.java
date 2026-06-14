package devinfo.projectManagementPlatform.services;

import devinfo.projectManagementPlatform.models.User;
import devinfo.projectManagementPlatform.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        if (user.getFirstName() == null) {
            throw new IllegalArgumentException("Fill in the first name!");
        }

        if (user.getLastName() == null) {
            throw new IllegalArgumentException("Fill in the last name!");
        }

        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Email must be filled out!");
        }

        if (user.getMobileNumber() == null) {
            throw new IllegalArgumentException("Fill out the mobile number!");
        }

        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Fill in your password!");
        }

        return userRepository.save(user);
    }
}
