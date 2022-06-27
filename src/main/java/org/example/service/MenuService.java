package org.example.service;
import java.util.List;
import org.example.dto.MenuDto;
import org.example.model.Menu;
import org.example.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MenuService
{
    @Autowired
    public MenuRepository repo;
    //Get
    public List<Menu> listAllmenu() {
        return repo.findAll();
    }
    public Menu add(MenuDto menuDto) {
        Menu menuModel = new Menu();
        menuModel.setItemName(menuDto.getItemName());
        menuModel.setItemPrice(menuDto.getItemPrice());
        menuModel.setItemQuantity(menuDto.getItemQuantity());
        menuModel.setItemDescription(menuDto.getItemDescription());
        return repo.save(menuModel);
    }
    public Menu getmenu(Menu menuModel) {
        return repo.save(menuModel);
    }
    public void deletemenu(Integer menuId) {
        repo.deleteById(menuId);
    }
}

