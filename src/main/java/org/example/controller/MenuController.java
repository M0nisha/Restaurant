
package org.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.example.model.MenuModel;

import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MenuController {

    @Autowired(required=true)
    public MenuService menuService;

    @GetMapping("/get")
    public List<MenuModel> list() {
        return menuService.listAllmenu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuModel> get(@PathVariable Integer id) {
        try {
            MenuModel menuModel = menuService.getmenuById(id);
            return new ResponseEntity<MenuModel>(menuModel, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<MenuModel>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody MenuModel menuModel) {
        menuService.savemenu(menuModel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody MenuModel menuModel, @PathVariable Integer id) {
        try {
            menuModel.setId(id);
            menuService.getmenu(menuModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        menuService.deletemenu(id);
    }
}