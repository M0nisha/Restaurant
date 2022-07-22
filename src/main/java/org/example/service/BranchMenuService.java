package org.example.service;
import org.example.exception.APIResponse;
import org.example.model.BranchMenu;
import org.example.repository.BranchMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BranchMenuService {
    @Autowired
    public BranchMenuRepository branchMenuRepository;
    public ResponseEntity<Map<String, Object>>  listAllBranchMenu(int page , int size)
    {
        List<BranchMenu> branchMenuList =new ArrayList<>();
        Pageable paging = PageRequest.of(page, size);
        Page<BranchMenu> branchMenuPage = branchMenuRepository.findAll(paging);
        branchMenuList =  branchMenuPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("BranchMenuList" , branchMenuList);
        response.put("CurrentPage", branchMenuPage.getNumber());
        response.put("TotalItems" , branchMenuPage.getTotalElements());
        response.put("TotalPages", branchMenuPage.getTotalPages());
        response.put("isFirst", branchMenuPage.isFirst());
        response.put("isLast", branchMenuPage.isLast());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public APIResponse addbranchmenu(BranchMenu branchMenu) {
          APIResponse apiResponse = new APIResponse();
          branchMenu.getBranchId();
          branchMenu.getMenuId();
          branchMenu = branchMenuRepository.save(branchMenu);
          apiResponse.setMessage("BranchMenu Details Added Successfully");
          apiResponse.setData(branchMenu);
          return apiResponse;
    }
    public APIResponse updatebyid(BranchMenu branchMenu) {
        APIResponse apiResponse = new APIResponse();
        Map<String , Object> data = new HashMap<>();
        branchMenu=branchMenuRepository.save(branchMenu);
        apiResponse.setData(branchMenu);
        apiResponse.setMessage("updated Successfully");
        return apiResponse;
    }
    public void  deletebranchmenuid(Long id ) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(" Branch menu " +id+ " details deleted Successfully ");
        branchMenuRepository.deleteById(id);
    }

}


