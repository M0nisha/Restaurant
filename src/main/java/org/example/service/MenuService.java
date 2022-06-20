package org.example.service;
import java.util.List;
import org.example.model.MenuModel;
import org.example.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class MenuService
{
    @Autowired(required=true)
     MenuRepository repo;
    //Get
    public List<MenuModel> listAllmenu() {

        return repo.findAll();
    }

    public void savemenu(MenuModel menuModel) {

        repo.save(menuModel);
    }

    public MenuModel getmenu(MenuModel id) {

        return repo.save(id);
    }

    public void deletemenu(Integer id) {

        repo.deleteById(id);
    }

    public MenuModel getmenuById(Integer id) {

        return repo.getById(id);

    }
}

