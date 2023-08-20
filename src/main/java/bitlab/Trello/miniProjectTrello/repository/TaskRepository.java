package bitlab.Trello.miniProjectTrello.repository;

import bitlab.Trello.miniProjectTrello.model.Folder;
import bitlab.Trello.miniProjectTrello.model.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByFolderOrderById(Folder folder);
}
