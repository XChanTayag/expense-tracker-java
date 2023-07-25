package com.oyo.expensetracker.model;

import com.oyo.expensetracker.model.audit.AbstractAuditId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction extends AbstractAuditId {

    private String type;

    private BigDecimal amount;

    private String category;

    private String account;

    private String remarks;

    private LocalDateTime date;
}
