package bitlab.Trello.miniProjectTrello.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String comment;

    @Column(name = "added_time")
    private LocalDateTime addedTime;

    @ManyToOne
    private Tasks task;
}
