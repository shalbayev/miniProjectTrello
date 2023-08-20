package bitlab.Trello.miniProjectTrello.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_folder_category")
@Getter
@Setter
@ToString
public class FolderCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column
    private String name;
}
