package com.oyo.expensetracker.model.audit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oyo.expensetracker.model.AbstractId;
import com.oyo.expensetracker.model.constant.CommonConstant;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditId extends AbstractId {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonConstant.DATE_FORMAT_1)
    @CreatedDate
    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonConstant.DATE_FORMAT_1)
    @LastModifiedDate
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}
