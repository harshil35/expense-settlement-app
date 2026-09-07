package com.settleflow.controller;

import com.settleflow.dto.CreateExpenseGroupRequest;
import com.settleflow.dto.ExpenseGroupResponse;
import com.settleflow.service.ExpenseGroupService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class ExpenseGroupController {

    private final ExpenseGroupService expenseGroupService;

    public ExpenseGroupController(
            ExpenseGroupService expenseGroupService) {
        this.expenseGroupService = expenseGroupService;
    }

    @PostMapping
    public ResponseEntity<ExpenseGroupResponse> createGroup(
            @Valid @RequestBody CreateExpenseGroupRequest request) {

        ExpenseGroupResponse response =
                expenseGroupService.createGroup(request);

        URI location = URI.create("/api/v1/groups/" + response.id());

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public List<ExpenseGroupResponse> getGroups() {
        return expenseGroupService.getGroups();
    }
}