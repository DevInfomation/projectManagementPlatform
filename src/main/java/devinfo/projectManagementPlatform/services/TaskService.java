package devinfo.projectManagementPlatform.services;

import devinfo.projectManagementPlatform.models.Task;
import devinfo.projectManagementPlatform.models.User;
import devinfo.projectManagementPlatform.repositories.TaskRepository;
import devinfo.projectManagementPlatform.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        Long memberId = task.getMembers().getId();
        User member = userRepository.findById(String.valueOf(memberId))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        task.setMembers(member);
        return taskRepository.save(task);
    }
}
