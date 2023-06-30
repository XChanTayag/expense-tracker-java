package com.oyo.expensetracker.model.dto.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseAddParam {

    BigDecimal amount;

    String category;

    String account;

    String remarks;

    LocalDate date;
}
