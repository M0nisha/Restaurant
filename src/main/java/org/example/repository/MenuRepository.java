package org.example.repository;
import org.example.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
//    @Override
//    @Transactional
//    @Modifying
//    @Query(value = "select e from  Menu e where e.isActive = true", nativeQuery = true)
//    List<Menu> findAll();

    @Query(value = "update Menu e set e.isActive = false where e.id = :menuId", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteById(Integer menuId);

    Optional<List<Menu>> findByIsActiveTrue();

}
