package org.example.controller;
import org.example.dto.MenuDto;
import org.example.model.Menu;
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
    public ResponseEntity<List<Menu>> list() {
        return ResponseEntity.ok().body(menuService.listAllmenu());
    }


    @PostMapping("/")
    public ResponseEntity<ResponseModel> add(@Valid @RequestBody MenuDto menuDto) {
        return ResponseEntity.ok().body(new ResponseModel(menuService.add(menuDto)));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody Menu menuModel) {
        menuService.getmenu(menuModel);
        return ResponseEntity.ok().body(menuModel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer menuId) {
        menuService.deletemenu(menuId);
        return ResponseEntity.ok().body("Deleted successfully");
    }
}