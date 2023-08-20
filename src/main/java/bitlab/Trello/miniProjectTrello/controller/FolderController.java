package bitlab.Trello.miniProjectTrello.controller;


import bitlab.Trello.miniProjectTrello.model.Folder;
import bitlab.Trello.miniProjectTrello.model.FolderCategories;
import bitlab.Trello.miniProjectTrello.service.FolderService;
import bitlab.Trello.miniProjectTrello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/folder")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "{id}")
    public String details(@PathVariable(name = "id") Long id, Model model){
        Folder folder = folderService.getFolder(id);
        model.addAttribute("folder", folder);
        List<FolderCategories> categories = folderService.getCategories();
        categories.removeAll(folder.getCategories());
        model.addAttribute("categories",categories);
        model.addAttribute("tasks", taskService.getTasks(folder));
        return "folder-details";
    }

    @PostMapping(value = "/add")
    public String addFolderModal(Folder folder){
        folderService.addFolder(folder);
        return "redirect:/";
    }
}
