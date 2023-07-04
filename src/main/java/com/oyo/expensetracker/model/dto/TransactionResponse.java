package com.oyo.expensetracker.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class TransactionResponse {

    private UUID id;

    private String type;

    private BigDecimal amount;

    private String category;

    private String account;

    private String remarks;

    private LocalDate date;
}
