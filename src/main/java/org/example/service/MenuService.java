package org.example.service;
import org.example.dto.MenuDto;
import org.example.exception.APIResponse;
import org.example.model.Menu;
import org.example.model.MenuTable;
import org.example.repository.MenuRepository;
import org.example.repository.MenuTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MenuService {
    @Autowired
    public MenuRepository repo;


    @Autowired
    public MenuTableRepository menuTableRepository;

    private Long timestamp = System.currentTimeMillis();

    public ResponseEntity<Map<String, Object>> listAllMenu(int page, int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Menu> menuPage = repo.findAll(paging);
        List<Menu> allItems;

        if (timestamp > 10L) {
            Stream<Menu> hikedList = menuPage.stream().map(i -> {
                if (i.getMenuId() % 2 == 0) {
                    i.setItemPrice(i.getItemPrice() * 3);
                } else {
                    i.setItemPrice(i.getItemPrice() * 4);
                }
                MenuTable menuTable = new MenuTable();
                menuTable.setId(i.getMenuId());
                menuTable.setDescription(i.getItemDescription());
                menuTable.setName(i.getItemName());
                menuTable.setPrice(i.getItemPrice());
                menuTable.setQuantity(i.getItemQuantity());
                menuTableRepository.save(menuTable);
                return i;
            });
            allItems = hikedList.collect(Collectors.toList());
        } else {
            allItems = menuPage.getContent();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("CurrentPage", menuPage.getNumber());
        response.put("TotalItems", menuPage.getTotalElements());
        response.put("TotalPages", menuPage.getTotalPages());
        response.put("isFirst", menuPage.isFirst());
        response.put("isLast", menuPage.isLast());
        response.put("menuList", allItems);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public APIResponse add(MenuDto menuDto) {
        APIResponse apiResponse = new APIResponse();
        Menu menuModel = new Menu();
        menuModel.setItemName(menuDto.getItemName());
        menuModel.setItemPrice(menuDto.getItemPrice());
        menuModel.setItemQuantity(menuDto.getItemQuantity());
        menuModel.setItemDescription(menuDto.getItemDescription());
        menuModel = repo.save(menuModel);
        apiResponse.setMessage("Menu details added successfully");
        apiResponse.setData(menuModel);
        return apiResponse;
    }
    public APIResponse updateMenu(Menu menuModel) {
        APIResponse apiResponse = new APIResponse();
        Map<String, Object> data = new HashMap<>();
        menuModel = repo.save(menuModel);
        apiResponse.setMessage("Menu details updated successfully");
        apiResponse.setData(menuModel);
        return apiResponse;
    }
    public void deletemenu(Integer menuId) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage("Menu details deleted successfully");
        repo.deleteById(menuId);
    }

}

