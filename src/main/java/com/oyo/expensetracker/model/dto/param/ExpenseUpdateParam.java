package com.oyo.expensetracker.model.dto.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseUpdateParam extends ExpenseAddParam{
    private UUID id;
}
