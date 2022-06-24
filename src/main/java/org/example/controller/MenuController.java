package org.example.controller;
import org.example.dto.MenuDto;
import org.example.model.BranchMenu;
import org.example.model.MenuModel;
import org.example.model.ResponseModel;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    public MenuService menuService;

    @GetMapping("/")
    public ResponseEntity<List<MenuModel>> list() {
        return ResponseEntity.ok().body(menuService.listAllmenu());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getid(@PathVariable Integer menuId) {
        List<Object> menuModel = menuService.getmenuById(menuId);

        return new ResponseEntity<>(menuModel, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseModel> add(@Valid @RequestBody MenuDto menuDto) {
        return ResponseEntity.ok().body(new ResponseModel(menuService.add(menuDto)));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody MenuModel menuModel) {
        menuService.getmenu(menuModel);
        return ResponseEntity.ok().body(menuModel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer menuId) {
        menuService.deletemenu(menuId);
        return ResponseEntity.ok().body("Deleted successfully");
    }
    @GetMapping("/menu-items")
    public ResponseEntity<?> getMenuItems(@RequestParam("menuId")  Integer menuId) {
        return ResponseEntity.ok().body(menuService.getmenuById(menuId));
    }
}