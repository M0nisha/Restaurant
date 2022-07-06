package org.example.repository;
import org.example.model.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends PagingAndSortingRepository<Menu, Integer > {
}
