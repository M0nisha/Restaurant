package org.example.repository;

import org.example.model.MenuTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuTableRepository extends JpaRepository<MenuTable, Integer> {
}
