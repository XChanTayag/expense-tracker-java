package com.oyo.expensetracker.mapper;

import com.oyo.expensetracker.model.Transaction;
import com.oyo.expensetracker.model.dto.TransactionResponse;
import com.oyo.expensetracker.model.dto.param.TransactionAddParam;
import com.oyo.expensetracker.model.dto.param.TransactionUpdateParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Component
public class ExpenseMapper {

    public static TransactionResponse toResponse(Transaction transaction) {
        TransactionResponse transactionResponse = TransactionResponse.builder().build();

        BeanUtils.copyProperties(transaction, transactionResponse);
        transactionResponse.setDate(transaction.getDate()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        return transactionResponse;
    }

    public static Transaction toEntity(TransactionAddParam transactionAddParam) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionAddParam, transaction);

        return transaction;
    }

    public static Transaction toEntity(TransactionUpdateParam expenseUpdateParam) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(expenseUpdateParam, transaction);

        return transaction;
    }

}
