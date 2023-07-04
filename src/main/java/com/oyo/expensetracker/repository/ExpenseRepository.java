package com.oyo.expensetracker.repository;

import com.oyo.expensetracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Transaction, UUID> {
}
