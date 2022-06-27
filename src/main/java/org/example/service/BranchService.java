package org.example.service;
import java.util.List;
import org.example.dto.BranchDto;
import org.example.model.Branch;
import org.example.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService
{
    @Autowired
    public BranchRepository repository;
    //Get
    public List<Branch> listAll()
    {
        return repository.findAll();
    }

    //getbyid
    public Branch get(Integer branchId) {
        return  repository. getById(branchId );
    }
    //post
    public Branch add(BranchDto branchDto)
    {
        Branch branch = new Branch();
        branch.setBranchName(branchDto.getBranchName());
        branch.setPincode(branchDto.getPincode());
        branch.setArea(branchDto.getArea());
        return repository.save(branch);
    }
    //put
    public Branch update(Branch branch) {
        return repository.save(branch);
    }
    //delete
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }
}










