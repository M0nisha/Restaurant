package org.example.controller;
import org.example.dto.BranchDto;
import org.example.model.Branch;
import org.example.model.ResponseModel;
import org.example.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/branch")
public class BranchController {
    @Autowired
    public BranchService branchService;


    @GetMapping("")
    public ResponseEntity<List<Branch>> list() {
        return  ResponseEntity.ok().body(branchService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> get(@PathVariable Integer branchId) {
        Branch branch = branchService.get(branchId) ;
        return new  ResponseEntity<>(branch, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseModel> add(@Valid @RequestBody BranchDto branchDto) {
        return ResponseEntity.ok().body(new ResponseModel(branchService.add(branchDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Branch branch) {
        return  ResponseEntity.ok().body( branchService.update(branch));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer branchId) {
        branchService.delete(branchId);
        return ResponseEntity.ok().body("Branch details deleted Successfully");
    }
}
