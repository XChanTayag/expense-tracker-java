package com.oyo.expensetracker.controller;

import com.oyo.expensetracker.model.dto.TransactionResponse;
import com.oyo.expensetracker.model.dto.param.TransactionAddParam;
import com.oyo.expensetracker.model.dto.param.TransactionUpdateParam;
import com.oyo.expensetracker.model.dto.param.MultipleIdParam;
import com.oyo.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService expenseService;

    @GetMapping
    public List<TransactionResponse> getAll(){
        return expenseService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse create(@RequestBody TransactionAddParam transactionAddParam){
        return expenseService.create(transactionAddParam);
    }

    @PutMapping
    public TransactionResponse update(@RequestBody TransactionUpdateParam transactionUpdateParam){
        return expenseService.update(transactionUpdateParam);
    }

    @DeleteMapping
    public void delete(@RequestBody MultipleIdParam multipleIdParam){
        expenseService.delete(multipleIdParam);
    }
}
