package bitlab.Trello.miniProjectTrello.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "t_folder")
@Getter
@Setter
@ToString
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<FolderCategories> categories;

    public void removeCategory(FolderCategories category) {
        categories.remove(category);
    }

}
