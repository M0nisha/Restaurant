package org.example.repository;
import org.example.model.BranchMenu;
import org.example.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Integer > {
    @Query(value = "select b.area, b.branch, m.item_name, m.item_price, m.item_quantity, m.item_description from branchs b inner join  menu_items m WHERE b.branch_id=m.menu_id" , nativeQuery = true)
    List<Object> getMenuItems(@Param("menu_id") int menuId);
}
