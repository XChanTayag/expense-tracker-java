package com.oyo.expensetracker.exception;

public class ExpenseException extends RuntimeException{

    public ExpenseException(String companyNotFound) {
        super(companyNotFound);
    }
}
