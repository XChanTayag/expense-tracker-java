package com.oyo.expensetracker.controller;

import com.oyo.expensetracker.model.dto.ExpenseResponse;
import com.oyo.expensetracker.model.dto.param.ExpenseAddParam;
import com.oyo.expensetracker.model.dto.param.ExpenseUpdateParam;
import com.oyo.expensetracker.model.dto.param.MultipleIdParam;
import com.oyo.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<ExpenseResponse> getAll(){
        return expenseService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseResponse create(@RequestBody ExpenseAddParam expenseAddParam){
        return expenseService.create(expenseAddParam);
    }

    @PutMapping
    public ExpenseResponse update(@RequestBody ExpenseUpdateParam expenseUpdateParam){
        return expenseService.update(expenseUpdateParam);
    }

    @PutMapping
    public void update(@RequestBody MultipleIdParam multipleIdParam){
        expenseService.delete(multipleIdParam);
    }
}
