package bitlab.Trello.miniProjectTrello.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String title;


    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private int status;


    @ManyToOne
    private Folder folder;
}
