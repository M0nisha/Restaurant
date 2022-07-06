package org.example.controller;
import org.example.dto.BranchDto;
import org.example.exception.APIResponse;
import org.example.model.Branch;
import org.example.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/branch")
public class BranchController {
    @Autowired
    public BranchService branchService;
    @GetMapping
    public  ResponseEntity<Map<String, Object>> listAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size)  {
       return  branchService.listAllBranch(0 , 5);
    }
    @PostMapping
    public ResponseEntity<APIResponse> add(@Valid @RequestBody BranchDto branchDto, Pageable pageable)
    {
         APIResponse apiResponse = branchService.add(branchDto);
       return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
  @PutMapping
    public ResponseEntity<APIResponse> update(@Valid @RequestBody Branch branch)
    {
        APIResponse apiResponse = branchService.update(branch);
        return  ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
    @DeleteMapping
    public ResponseEntity<APIResponse> delete(@Valid @PathVariable Integer branchId)
    {
        branchService.delete(branchId);
        return ResponseEntity.ok().build();
    }
}

