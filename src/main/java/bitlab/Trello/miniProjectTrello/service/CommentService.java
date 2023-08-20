package bitlab.Trello.miniProjectTrello.service;


import bitlab.Trello.miniProjectTrello.model.Comment;
import bitlab.Trello.miniProjectTrello.model.Tasks;
import bitlab.Trello.miniProjectTrello.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Tasks task){
        return commentRepository.findAllByTask(task);
    }
}
