package org.example.repository;
import org.example.model.BranchMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BranchMenuRepository extends JpaRepository<BranchMenu, Integer>
{
    @Query(value = "SELECT branch.branch_id , branch.branch_name, branch.area, branch.pincode,menu_items.menu_id,  menu_items.item_name,menu_items.item_price, menu_items.item_quantity, menu_items.item_description from branch INNER JOIN menu_items  ON branch.branch_id = menu_items.menu_id  WHERE branch.branch_id = branchId"  , nativeQuery = true)
    List<BranchMenu> findByBranchId(Integer branch_id);

}
/*
   SELECT branch.branch_name, branch.area, branch.pincode, menu_items.item_name,menu_items.item_price, menu_items.item_quantity, menu_items.item_description from branch INNER JOIN menu_items  ON branch.branch_id = menu_items.menu_id;
 */
