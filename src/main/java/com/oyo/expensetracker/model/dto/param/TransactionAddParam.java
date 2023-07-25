package com.oyo.expensetracker.model.dto.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionAddParam {

    private String type;

    private BigDecimal amount;

    private String category;

    private String account;

    private String remarks;

    private LocalDateTime date;
}
