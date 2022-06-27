package org.example.service;

import org.example.model.BranchMenu;
import org.example.repository.BranchMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchMenuService {

    @Autowired
    public BranchMenuRepository branchMenuRepository;

    public List<BranchMenu> listbranchmenu() {
        return  branchMenuRepository.findAll();
    }


    public BranchMenu addbranchmenu(BranchMenu branchMenu) {
        return  branchMenuRepository.save(branchMenu);
    }
    public BranchMenu updatebyid(BranchMenu branchMenu) {

        return branchMenuRepository.save(branchMenu);
    }
    public void  deletebranchmenuid(Integer branchId) {
        branchMenuRepository.deleteById(branchId);
    }


    public  List<BranchMenu> getmenuitems(Integer branchId)
    {
        return branchMenuRepository.findByBranchId(branchId);
    }
}


