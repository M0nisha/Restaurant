package org.example.service;
import java.util.List;
import org.example.dto.MenuDto;
import org.example.model.BranchMenu;
import org.example.model.MenuModel;
import org.example.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MenuService
{
    @Autowired
    public MenuRepository repo;
    //Get
    public List<MenuModel> listAllmenu() {
        return repo.findAll();
    }
    public MenuModel add(MenuDto menuDto) {
        MenuModel menuModel = new MenuModel();
        menuModel.setItemName(menuDto.getItemName());
        menuModel.setItemPrice(menuDto.getItemPrice());
        menuModel.setItemQuantity(menuDto.getItemQuantity());
        menuModel.setItemDescription(menuDto.getItemDescription());
        return repo.save(menuModel);
    }
    public MenuModel getmenu(MenuModel menuModel) {
        return repo.save(menuModel);
    }
    public void deletemenu(Integer menuId) {
        repo.deleteById(menuId);
    }
    public List<Object> getmenuById(Integer menuId) {
        return repo.getMenuItems(menuId);
    }

}

