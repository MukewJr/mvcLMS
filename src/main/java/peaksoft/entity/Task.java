package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_text")
    private String taskText;

    private LocalDate deadLine;

    public Task(String taskName, String taskText, LocalDate deadLine) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadLine = deadLine;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private Lesson lessons;
}
