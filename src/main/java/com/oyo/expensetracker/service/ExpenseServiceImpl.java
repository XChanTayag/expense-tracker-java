package com.oyo.expensetracker.service;

import com.oyo.expensetracker.exception.ExpenseException;
import com.oyo.expensetracker.mapper.ExpenseMapper;
import com.oyo.expensetracker.model.Expense;
import com.oyo.expensetracker.model.dto.ExpenseResponse;
import com.oyo.expensetracker.model.dto.param.ExpenseAddParam;
import com.oyo.expensetracker.model.dto.param.ExpenseUpdateParam;
import com.oyo.expensetracker.model.dto.param.MultipleIdParam;
import com.oyo.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    public static final String EXPENSE_NOT_FOUND = "Expense not Found";
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<ExpenseResponse> getAll() {
        return expenseRepository.findAll().stream()
                .map(ExpenseMapper::toResponse).toList();
    }

    @Override
    public ExpenseResponse create(ExpenseAddParam expenseAddParam) {
        Expense expense = ExpenseMapper.toEntity(expenseAddParam);
        expense.setCreatedTime(LocalDateTime.now());
        return ExpenseMapper.toResponse(expenseRepository.save(expense));
    }

    @Override
    public ExpenseResponse update(ExpenseUpdateParam expenseUpdateParam) {
        expenseRepository.findById(expenseUpdateParam.getId())
                .orElseThrow(() -> new ExpenseException(EXPENSE_NOT_FOUND));
        Expense expense = ExpenseMapper.toEntity(expenseUpdateParam);
        expense.setUpdatedTime(LocalDateTime.now());

        return ExpenseMapper.toResponse(expenseRepository.save(expense));
    }

    @Override
    public void delete(MultipleIdParam multipleIdParam) {
        expenseRepository.deleteAllById(multipleIdParam.getIds());
    }
}
