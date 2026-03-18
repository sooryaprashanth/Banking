package com.practise.banking.Repository;

import com.practise.banking.DTO.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
