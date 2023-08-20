package bitlab.Trello.miniProjectTrello.repository;

import bitlab.Trello.miniProjectTrello.model.Folder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface FolderRepository extends JpaRepository<Folder,Long> {
}
