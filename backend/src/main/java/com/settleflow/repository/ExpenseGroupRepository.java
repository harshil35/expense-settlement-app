package com.settleflow.repository;

import com.settleflow.model.ExpenseGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup, Long> {
}