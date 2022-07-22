package org.example.service;
import org.example.dto.BranchDto;
import org.example.exception.APIResponse;
import org.example.model.Branch;
import org.example.repository.BranchRepository;
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
public class BranchService {
    @Autowired
    public BranchRepository repository;


    public ResponseEntity<Map<String, Object>> listAllBranch( int page , int size) {

        List<Branch> branchList = new ArrayList<>();
        Pageable paging = PageRequest.of(page, size);
        Page<Branch> branchPage = repository.findAll(paging);
        branchList = branchPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("BranchList", branchList);
        response.put("CurrentPage", branchPage.getNumber());
        response.put("TotalItems", branchPage.getTotalElements());
        response.put("TotalPages", branchPage.getTotalPages());
        response.put("isFirst", branchPage.isFirst());
        response.put("isLast", branchPage.isLast());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public APIResponse add(BranchDto branchDto) {
        APIResponse apiResponse = new APIResponse();
        Branch branch = new Branch();
        branch.setBranchName(branchDto.getBranchName());
        branch.setPincode(branchDto.getPincode());
        branch.setArea(branchDto.getArea());
        branch = repository.save(branch);
        apiResponse.setData(branch);
        apiResponse.setMessage("Branch details Added Successfully");
        return apiResponse;
    }

    public APIResponse update(Branch branch) {
        APIResponse apiResponse = new APIResponse();
        Map<String, Object> data = new HashMap<>();
        branch = repository.save(branch);
        apiResponse.setData(branch);
        apiResponse.setMessage("Branch details updated Successfully");
        return apiResponse;
    }

    public void delete(Integer id) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage("Branch" + id + "deleted Successfully");
        repository.deleteById(id);
    }

}











