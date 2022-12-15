package com.fmsshr.fmssdemohr.dtos.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmsshr.fmssdemohr.enums.SpendingType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class EmployeeExpenseResponseDto {
    private Long userId;

    private SpendingType spendingType;

    private int spendingAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;

    private int taxRate;

    private String spendingDefinition;

    private Long spendingId;
}
