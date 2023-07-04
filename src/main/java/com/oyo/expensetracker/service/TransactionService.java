package com.oyo.expensetracker.service;

import com.oyo.expensetracker.model.dto.TransactionResponse;
import com.oyo.expensetracker.model.dto.param.TransactionAddParam;
import com.oyo.expensetracker.model.dto.param.TransactionUpdateParam;
import com.oyo.expensetracker.model.dto.param.MultipleIdParam;

import java.util.List;

public interface TransactionService {
    List<TransactionResponse> getAll();

    TransactionResponse create(TransactionAddParam transactionAddParam);

    TransactionResponse update(TransactionUpdateParam expenseUpdateParam);

    void delete(MultipleIdParam multipleIdParam);
}
