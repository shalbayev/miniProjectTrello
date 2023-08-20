package bitlab.Trello.miniProjectTrello.controller;


import bitlab.Trello.miniProjectTrello.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/folder-category")
public class FolderCategoryController {

    @Autowired
    private FolderService folderService;

    @PostMapping(value = "/add")
    public String addFolder(@RequestParam(name = "folder_id") Long folder_id,
                            @RequestParam(name = "category_id") Long category_id){
        folderService.assignCategory(folder_id,category_id);
        return "redirect:/folder/" + folder_id;
    }

    @PostMapping(value = "/delete")
    public String deleteFolder(@RequestParam(name = "folder_id") Long folder_id,
                               @RequestParam(name = "category_id") Long category_id){
        folderService.removeCategory(folder_id,category_id);
        return "redirect:/folder/" + folder_id;
    }
}
