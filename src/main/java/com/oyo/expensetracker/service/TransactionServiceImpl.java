package com.oyo.expensetracker.service;

import com.oyo.expensetracker.exception.ExpenseException;
import com.oyo.expensetracker.mapper.ExpenseMapper;
import com.oyo.expensetracker.model.Transaction;
import com.oyo.expensetracker.model.dto.TransactionResponse;
import com.oyo.expensetracker.model.dto.param.TransactionAddParam;
import com.oyo.expensetracker.model.dto.param.TransactionUpdateParam;
import com.oyo.expensetracker.model.dto.param.MultipleIdParam;
import com.oyo.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    public static final String EXPENSE_NOT_FOUND = "Transaction not Found";
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<TransactionResponse> getAll() {
        return expenseRepository.findAll().stream()
                .map(ExpenseMapper::toResponse)
                .sorted(Comparator.comparing(TransactionResponse::getDate).reversed()).toList();
    }

    @Override
    public TransactionResponse create(TransactionAddParam transactionAddParam) {
        Transaction transaction = ExpenseMapper.toEntity(transactionAddParam);
        transaction.setCreatedTime(LocalDateTime.now());
        return ExpenseMapper.toResponse(expenseRepository.save(transaction));
    }

    @Override
    public TransactionResponse update(TransactionUpdateParam expenseUpdateParam) {
        expenseRepository.findById(expenseUpdateParam.getId())
                .orElseThrow(() -> new ExpenseException(EXPENSE_NOT_FOUND));
        Transaction transaction = ExpenseMapper.toEntity(expenseUpdateParam);
        transaction.setUpdatedTime(LocalDateTime.now());

        return ExpenseMapper.toResponse(expenseRepository.save(transaction));
    }

    @Override
    public void delete(MultipleIdParam multipleIdParam) {
        expenseRepository.deleteAllById(multipleIdParam.getIds());
    }
}
