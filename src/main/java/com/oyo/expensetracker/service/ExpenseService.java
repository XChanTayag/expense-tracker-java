package com.oyo.expensetracker.service;

import com.oyo.expensetracker.model.dto.ExpenseResponse;
import com.oyo.expensetracker.model.dto.param.ExpenseAddParam;
import com.oyo.expensetracker.model.dto.param.ExpenseUpdateParam;
import com.oyo.expensetracker.model.dto.param.MultipleIdParam;

import java.util.List;

public interface ExpenseService {
    List<ExpenseResponse> getAll();

    ExpenseResponse create(ExpenseAddParam expenseAddParam);

    ExpenseResponse update(ExpenseUpdateParam expenseUpdateParam);

    void delete(MultipleIdParam multipleIdParam);
}
