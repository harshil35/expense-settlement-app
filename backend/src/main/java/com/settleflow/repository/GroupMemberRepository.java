package com.settleflow.repository;

import com.settleflow.model.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    List<GroupMember> findByExpenseGroupIdOrderByCreatedAtAsc(Long expenseGroupId);
    boolean existsByExpenseGroupIdAndEmail(Long expenseGroupId, String email);
}