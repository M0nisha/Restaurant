package org.example.controller;
import java.util.List;
import org.example.DTO.BranchDTO;
import org.example.model.BranchModel;
import org.example.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BranchController {

    @Autowired(required=true)
    public BranchService branchservice;


    @GetMapping("/get")
    public List<BranchModel> list() {
        return branchservice.listAllbranch();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BranchDTO> get(@PathVariable Integer id  ,
                                         @RequestParam (value = "MenuItems",required = false) boolean MenuItems) {

            BranchDTO dto = branchservice.getBranchbyid(id ,MenuItems);
            return new ResponseEntity<>(dto, HttpStatus.OK);

    }
    @PostMapping("/post")
    public void add(@RequestBody BranchModel branchModel) {

       branchservice.savebranch(branchModel);}


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody  BranchModel branchModel, @PathVariable Integer id) {

            branchModel.setId(id);
            branchservice.getbranch(branchModel);
            return new ResponseEntity<>("Branch details Updated Successfully" , HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id)
    {
        branchservice.deletebranch(id);
    }
}
