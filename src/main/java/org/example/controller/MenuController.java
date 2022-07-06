package org.example.controller;
import org.example.dto.MenuDto;
import org.example.exception.APIResponse;
import org.example.model.Menu;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    public MenuService menuService;
    @GetMapping("/all")
    public  ResponseEntity<Map<String, Object>> listAll( @RequestParam(defaultValue = "0")  int page ,
                                                         @RequestParam(defaultValue = "16") int size  )
//                                                         @RequestParam (defaultValue = "menuId") String SortBy)
    {
        return menuService.listAllMenu( page , size );
    }

    @PostMapping
    public ResponseEntity<APIResponse> add(@Valid @RequestBody MenuDto menuDto) {
        APIResponse apiResponse = menuService.add(menuDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping
    public ResponseEntity<APIResponse> update(@Valid @RequestBody Menu menuModel) {
        APIResponse apiResponse = menuService.getmenu(menuModel);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer menuId)
    {
        menuService.deletemenu(menuId);
        return ResponseEntity.ok().build();
    }
}