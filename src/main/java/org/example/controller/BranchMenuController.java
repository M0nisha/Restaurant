package org.example.controller;
import org.example.model.BranchMenu;
import org.example.service.BranchMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/branch-menu")
public class BranchMenuController {

    @Autowired
    public BranchMenuService service;


    @GetMapping("")
    public ResponseEntity<List<BranchMenu>> listbranchmenu() {
        return ResponseEntity.ok().body(service.listbranchmenu());
    }

    @PostMapping("")
    public ResponseEntity<BranchMenu> addbranchmenu( @RequestBody BranchMenu branchMenu) {
        return ResponseEntity.ok().body(service.addbranchmenu(branchMenu));
    }

    @PutMapping("")
    public ResponseEntity<?> updatebranchmenu( @RequestBody BranchMenu branchMenu) {
      service.updatebyid(branchMenu);
        return ResponseEntity.ok().body(branchMenu);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletebranchmenuid(@PathVariable Integer branchId) {
       service. deletebranchmenuid(branchId);
        return ResponseEntity.ok().body("Deleted successfully");
    }
    @GetMapping("/")
     public ResponseEntity<?> getmenuitems(@RequestParam("branchId") Integer branchId) {
         return ResponseEntity.ok().body(service.getmenuitems(branchId));
        }

}
