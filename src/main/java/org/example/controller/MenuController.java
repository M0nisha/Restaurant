package org.example.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dto.MenuDto;
import org.example.model.Menu;
import org.example.repository.MenuRepository;
import org.example.repository.UserRepository;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {
   @Autowired
    UserRepository userRepository;
    @Autowired
    public MenuRepository menuRepository;
    @Autowired
    public MenuService menuService;
    Logger logger = LogManager.getLogger(MenuController.class);
    @GetMapping("/listAllMenu")
    public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model)
    {
        ResponseEntity<Map<String, Object>> menu = menuService.listAllMenu(page, size);
        List<Menu> menulist =  menuRepository.findAll();
        model.addAttribute("menudto", menu);
        model.addAttribute("menudto",menulist);
        return "menu-list";
    }
    @GetMapping("/menuList")
    public String addNewMenu(Model model) {
        model.addAttribute("menudto", new MenuDto());
        return "add-menu";
    }
    @PostMapping("/menuList")
    public String saveMenu(@ModelAttribute  MenuDto menuDto, Model model, BindingResult result )
    {
        logger.info(menuDto.getItemName());
        logger.info(menuDto.getItemPrice());
        logger.info(menuDto.getItemQuantity());
        logger.info(menuDto.getItemDescription());
        if(result.hasErrors())
        {
            return "menu-list";
        }
        menuService.add(menuDto);
        model.addAttribute("menu" ,"Menu Details Added Successfully");
        model.addAttribute("menudto",  menuRepository.findAll()
                .get(0));
        menuRepository.findAll().forEach(
                i -> logger.info("{}", i.getItemName())
        );
        return "menu-list";
    }
    @PutMapping("/update/{id}")
    public String updateForm(Menu menudto, Model model) {
        model.addAttribute("menudto", menuService.updateMenu(menudto));
        return "redirect:/listAllMenu";
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer menuId , Model model) {
        menuService.deletemenu(menuId);
    }
}