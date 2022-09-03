package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    private String duration;
    private String image;
    private String description;

    public Course(String courseName, LocalDate dateOfStart, String duration, String image, String description) {
        this.courseName = courseName;
        this.dateOfStart = dateOfStart;
        this.duration = duration;
        this.image = image;
        this.description = description;
    }

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
    private Company company;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH},
            mappedBy = "courses")
    private List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    private List<Student>students;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "courses")
    private List<Lesson>lessons;


    public void addInstructors(Instructor instructor) {
        if (instructors == null) {
            instructors = new ArrayList<>();
        } else {
            this.instructors.add(instructor);
        }
    }

    public void addStudents(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        } else {
            this.students.add(student);
        }
    }

    public void addLessons(Lesson lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
        } else {
            this.lessons.add(lesson);
        }
    }

}
