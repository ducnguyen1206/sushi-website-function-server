package com.personal.project.infrastructure.repository;

import com.personal.project.infrastructure.entity.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Optional<Branch> findByBranchId(String branchId);
}
