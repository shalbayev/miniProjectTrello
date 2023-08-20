package bitlab.Trello.miniProjectTrello.controller;


import bitlab.Trello.miniProjectTrello.model.Comment;
import bitlab.Trello.miniProjectTrello.model.Tasks;
import bitlab.Trello.miniProjectTrello.service.CommentService;
import bitlab.Trello.miniProjectTrello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/add")
    public String add(@RequestParam(name="comment") String comment,
                      @RequestParam(name = "task.id") Long taskId) {
        Tasks checkTask = taskService.getTask(taskId);
        if(checkTask!=null){
            Comment commentObj = new Comment();
            commentObj.setAddedTime(LocalDateTime.now());
            commentObj.setComment(comment);
            commentObj.setTask(checkTask);
            commentService.addComment(commentObj);
            return "redirect:/task/" + taskId;

        }
        return "redirect:/";
    }




}
