package com.settleflow.dto;

import java.time.Instant;

public record ExpenseGroupResponse(
        Long id,
        String name,
        Long version,
        Instant createdAt,
        Instant updatedAt) {
}