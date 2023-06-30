package com.oyo.expensetracker.advice;

import com.oyo.expensetracker.exception.ExpenseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleExpenseNotFoundException(ExpenseException exception){
        return new ErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND.name());
    }
}
