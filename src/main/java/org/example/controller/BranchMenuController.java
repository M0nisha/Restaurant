package org.example.controller;
import org.example.exception.APIResponse;
import org.example.model.BranchMenu;
import org.example.service.BranchMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/branch-menu")
public class BranchMenuController {

    @Autowired
    public BranchMenuService service;
    @GetMapping
    public  ResponseEntity<Map<String, Object>> listAll(@RequestParam (defaultValue = "0") int page , @RequestParam (defaultValue = "5")int size)  {
        return  service.listAllBranchMenu(0 , 5);
    }
    @PostMapping
    public ResponseEntity<APIResponse> addbranchmenu( @Valid  @RequestBody BranchMenu branchMenu) {
        APIResponse apiResponse = service.addbranchmenu(branchMenu);
        return  ResponseEntity.status(HttpStatus.valueOf(apiResponse.getStatus())).body(apiResponse);
    }
    @PutMapping
    public ResponseEntity<APIResponse> updatebranchmenu( @Valid @RequestBody BranchMenu branchMenu) {
        APIResponse apiResponse = service.updatebyid(branchMenu);
        return ResponseEntity.status(HttpStatus.valueOf(apiResponse.getStatus())).body(apiResponse);
    }

    @DeleteMapping
    public ResponseEntity<?> deletebranchmenuid(@PathVariable Long id) {

        service.deletebranchmenuid(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping
//    public ResponseEntity<?> getmenuitems(@RequestParam("branchId") Integer branchId) {
//        return ResponseEntity.ok().body(service.getmenuitems(branchId));
//    }

}
