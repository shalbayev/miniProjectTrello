package bitlab.Trello.miniProjectTrello.controller;
import bitlab.Trello.miniProjectTrello.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    @Autowired
    private FolderService folderService;


    @GetMapping(value = "/")
    public String homePage(Model model){
        model.addAttribute("folders", folderService.getAllFolders());
        return "index";
    }

}
