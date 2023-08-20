package bitlab.Trello.miniProjectTrello.controller;


import bitlab.Trello.miniProjectTrello.model.Comment;
import bitlab.Trello.miniProjectTrello.model.Tasks;
import bitlab.Trello.miniProjectTrello.service.CommentService;
import bitlab.Trello.miniProjectTrello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;


    @PostMapping(value = "/add")
    public String addTask(Tasks task){
        task  = taskService.addTask(task);
        return "redirect:/folder/" + task.getFolder().getId();
    }

    @GetMapping(value="{id}")
    public String details(@PathVariable(name="id") Long id,
                          Model model){
        Tasks task = taskService.getTask(id);

        List<Comment> comments = commentService.getComments(task);
        model.addAttribute("comments",comments);


        model.addAttribute("task", task);
        return "task-details";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(name = "task_id") Long taskId,
                         @RequestParam(name = "folder_id") Long folderId){
        taskService.deleteTask(taskId);
        return "redirect:/folder/" + folderId;
    }

    @PostMapping(value = "/save")
    public String update(@RequestParam(name = "task_id") Long taskId,
                         Tasks task){
        Tasks updatingTask = taskService.getTask(taskId);
        if(updatingTask!=null){
            updatingTask.setTitle(task.getTitle());
            updatingTask.setStatus(task.getStatus());
            updatingTask.setDescription(task.getDescription());
            taskService.upDateTask(task);
            return "redirect:/task/" + taskId;
        }
        return "redirect:/";
    }


}
