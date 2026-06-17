package devinfo.projectManagementPlatform.controllers;

import devinfo.projectManagementPlatform.models.Task;
import devinfo.projectManagementPlatform.repositories.TaskRepository;
import devinfo.projectManagementPlatform.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
@AllArgsConstructor
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/fetchAllTasks")
    public List<Task> fetchAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    public Task getById(@PathVariable Long id) {
        return taskRepository.getById(String.valueOf(id));
    }
}
