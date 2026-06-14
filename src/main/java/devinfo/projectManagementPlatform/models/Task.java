package devinfo.projectManagementPlatform.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COMPLETED")
    private Boolean isCompleted;

    @Column(name = "COMMENTS")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "MEMBERS_ID")
    private User members;
}
