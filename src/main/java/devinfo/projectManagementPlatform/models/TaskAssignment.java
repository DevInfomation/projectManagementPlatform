package devinfo.projectManagementPlatform.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TaskAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;

    private LocalDateTime assignedAt;

    private String assignedBy;
}
