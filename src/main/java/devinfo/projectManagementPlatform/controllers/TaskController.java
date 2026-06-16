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

    @RequestMapping(path = "/createTask", method = RequestMethod.POST)
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @RequestMapping(path = "/fetchAllTasks", method = RequestMethod.GET)
    public List<Task> fetchAllTasks() {
        return taskRepository.findAll();
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.GET)
    public Task getById(@PathVariable Long id) {
        return taskRepository.getById(String.valueOf(id));
    }
}
