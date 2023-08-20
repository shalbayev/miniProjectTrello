package bitlab.Trello.miniProjectTrello.service;


import bitlab.Trello.miniProjectTrello.model.Comment;
import bitlab.Trello.miniProjectTrello.model.Folder;
import bitlab.Trello.miniProjectTrello.model.Tasks;
import bitlab.Trello.miniProjectTrello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Tasks addTask(Tasks task){
        return taskRepository.save(task);
    }

    public List<Tasks> getTasks(Folder folder){
        return taskRepository.findAllByFolderOrderById(folder);
    }

    public Tasks getTask(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void upDateTask(Tasks task){
        taskRepository.save(task);
    }






}
