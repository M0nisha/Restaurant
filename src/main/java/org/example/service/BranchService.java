package org.example.service;
import java.util.List;

import org.example.dto.BranchDto;
import org.example.model.BranchModel;
import org.example.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService
{
    @Autowired
    public BranchRepository repository;


    //Get
    public List<BranchModel> listAll()
    {
        return repository.findAll();
    }

    //getbyid
    public BranchModel get(Integer branchId) {
        return  repository. getById(branchId);
    }
    //post
    public BranchModel add(BranchDto branchDto)
    {
        BranchModel branchModel = new BranchModel();
        branchModel.setBranch(branchDto.getBranch());
        branchModel.setPincode(branchDto.getPincode());
        branchModel.setArea(branchDto.getArea());
        return repository.save(branchModel);
    }
    //put
    public BranchModel update(BranchModel branchModel) {
        return repository.save(branchModel);
    }
    //delete
    public void delete(Integer branchId)
    {
    repository.deleteById(branchId);
    }
}










