package com.oyo.expensetracker.mapper;

import com.oyo.expensetracker.model.Expense;
import com.oyo.expensetracker.model.dto.ExpenseResponse;
import com.oyo.expensetracker.model.dto.param.ExpenseAddParam;
import com.oyo.expensetracker.model.dto.param.ExpenseUpdateParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public static ExpenseResponse toResponse(Expense expense){
        ExpenseResponse expenseResponse = ExpenseResponse.builder().build();

        BeanUtils.copyProperties(expense, expenseResponse);

        return expenseResponse;
    }

    public static Expense toEntity(ExpenseAddParam expenseAddParam){
        Expense expense = new Expense();
        BeanUtils.copyProperties(expenseAddParam, expense);

        return expense;
    }

    public static Expense toEntity(ExpenseUpdateParam expenseUpdateParam){
        Expense expense = new Expense();
        BeanUtils.copyProperties(expenseUpdateParam, expense);

        return expense;
    }

}
