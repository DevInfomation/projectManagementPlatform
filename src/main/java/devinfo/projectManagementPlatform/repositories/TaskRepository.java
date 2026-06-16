package devinfo.projectManagementPlatform.repositories;

import devinfo.projectManagementPlatform.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepository extends JpaRepository<Task, String>, JpaSpecificationExecutor<Task> {

}
