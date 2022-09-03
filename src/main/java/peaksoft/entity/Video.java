package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video {
    @Id
    @SequenceGenerator(
            name = "video_sequence",
            sequenceName = "video_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "video_sequence"
    )
    private Long id;
    @Column(name = "video_name")
    private String videoName;
    private String link;

    public Video(String videoName, String link) {
        this.videoName = videoName;
        this.link = link;
    }
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private Lesson lesson;
}
