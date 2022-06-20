package org.example.repository;
import org.example.model.BranchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository  extends JpaRepository<BranchModel, Integer> {
}
