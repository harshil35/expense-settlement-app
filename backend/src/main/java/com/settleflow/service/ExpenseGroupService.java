package com.settleflow.service;

import com.settleflow.dto.CreateExpenseGroupRequest;
import com.settleflow.dto.ExpenseGroupResponse;
import com.settleflow.model.ExpenseGroup;
import com.settleflow.repository.ExpenseGroupRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenseGroupService {

    private final ExpenseGroupRepository expenseGroupRepository;

    public ExpenseGroupService(
            ExpenseGroupRepository expenseGroupRepository) {
        this.expenseGroupRepository = expenseGroupRepository;
    }

    @Transactional
    public ExpenseGroupResponse createGroup(
            CreateExpenseGroupRequest request) {

        ExpenseGroup expenseGroup =
                new ExpenseGroup(request.getName().trim());

        ExpenseGroup savedGroup =
                expenseGroupRepository.save(expenseGroup);

        return toResponse(savedGroup);
    }

    @Transactional(readOnly = true)
    public List<ExpenseGroupResponse> getGroups() {
        return expenseGroupRepository
                .findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private ExpenseGroupResponse toResponse(
            ExpenseGroup expenseGroup) {

        return new ExpenseGroupResponse(
                expenseGroup.getId(),
                expenseGroup.getName(),
                expenseGroup.getVersion(),
                expenseGroup.getCreatedAt(),
                expenseGroup.getUpdatedAt());
    }
}