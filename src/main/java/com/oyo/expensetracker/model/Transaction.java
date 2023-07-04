package com.oyo.expensetracker.model;

import com.oyo.expensetracker.model.audit.AbstractAuditId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "expense")
public class Transaction extends AbstractAuditId{

    private String type;

    private BigDecimal amount;

    private String category;

    private String account;

    private String remarks;

    private LocalDate date;
}
