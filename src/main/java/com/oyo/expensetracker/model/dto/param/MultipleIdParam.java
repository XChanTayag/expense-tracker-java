package com.oyo.expensetracker.model.dto.param;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MultipleIdParam {

    private List<UUID> ids;
}
