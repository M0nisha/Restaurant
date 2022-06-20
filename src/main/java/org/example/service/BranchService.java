package org.example.service;
import java.util.ArrayList;
import java.util.List;
import org.example.DTO.BranchDTO;
import org.example.DTO.MenuDTO;
import org.example.model.BranchModel;
import org.example.model.BranchMenu;
import org.example.model.MenuModel;
import org.example.repository.BranchMenuRepository;
import org.example.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class BranchService
{
    @Autowired(required=true)
    public BranchRepository repository;
    @Autowired
     public BranchMenuRepository branchmenurepository;

    //Get
    public List<BranchModel> listAllbranch()
    {
        return repository.findAll();
    }
    public BranchDTO getBranchbyid (Integer id , boolean MenuItems) {

       BranchModel branchModel = null;
        List<BranchMenu>  items = null;
        if (MenuItems)
        {
            items = branchmenurepository.findAllByBranchId( id );
        }
        BranchDTO dto = new BranchDTO();

        //set branch details
        dto.setId(branchModel.getId());
        dto.setBranch(branchModel.getBranch());
        dto.setArea(branchModel.getArea());
        dto.setPincode(branchModel.getPincode());

        //get menu items
        List<MenuDTO> menuDTOList = new ArrayList<>();

        if(items != null) {
            for (BranchMenu branch_menu : items) {
                MenuModel menumodel = branch_menu.getMenumodel();

                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setId(menumodel.getId());
                menuDTO.setItem_name(menumodel.getItemName());
                menuDTO.setItem_price(menumodel.getItemPrice());
                menuDTO.setItem_quality(menumodel.getItemQuality());
                menuDTO.setItem_description(menumodel.getItemDescription());

                menuDTOList.add(menuDTO);
            }
            //set menu items
            dto.setItems(menuDTOList);
        }
        return dto;
    }

    public void savebranch(BranchModel branchModel) {
        repository.save(branchModel);
    }
    public BranchModel getbranch(BranchModel id) {
        return repository.save(id);
    }
    public void deletebranch(Integer id)
    {
        repository.deleteById(id);
    }
}

