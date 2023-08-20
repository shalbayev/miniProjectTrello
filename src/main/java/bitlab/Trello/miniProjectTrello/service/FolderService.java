package bitlab.Trello.miniProjectTrello.service;


import bitlab.Trello.miniProjectTrello.model.FolderCategories;
import bitlab.Trello.miniProjectTrello.model.Folder;
import bitlab.Trello.miniProjectTrello.repository.FolderCategoryRepository;
import bitlab.Trello.miniProjectTrello.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FolderCategoryRepository folderCategoryRepository;
    public Folder addFolder(Folder folder){
        return folderRepository.save(folder);
    }

    public List<Folder> getAllFolders(){
        return folderRepository.findAll();
    }

    public Folder getFolder(Long id){
        return folderRepository.findById(id).orElse(null);
    }

    public List<FolderCategories> getCategories(){
        return folderCategoryRepository.findAll();
    }

    public void assignCategory(Long folder_id, Long category_id){

        Folder folder = getFolder(folder_id);
        FolderCategories folderCategory = folderCategoryRepository.findById(category_id).orElse(null);

        if(folder!=null && folderCategory!=null && !folder.getCategories().contains(folderCategory)){
            folder.getCategories().add(folderCategory);
            folderRepository.save(folder);
        }

        System.out.println(folder);
        System.out.println(folderCategory);
    }
    public void removeCategory(Long folder_id, Long category_id){
        Folder folder = getFolder(folder_id);
        FolderCategories folderCategory = folderCategoryRepository.findById(category_id).orElse(null);
        if(folder!=null && folderCategory!=null && folder.getCategories().contains(folderCategory)){
            folder.getCategories().remove(folderCategory);
            folderRepository.save(folder);
        }
    }

    public void removeFolder(Long id){
        Folder folder = folderRepository.findById(id).orElse(null);
        if(folder!=null){
            folderRepository.delete(folder);
        }
    }
}
