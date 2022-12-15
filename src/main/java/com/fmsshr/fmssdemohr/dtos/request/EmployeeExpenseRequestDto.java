package com.fmsshr.fmssdemohr.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmsshr.fmssdemohr.enums.SpendingType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Getter
@Setter
public class EmployeeExpenseRequestDto {

    private Long userId;
    @NotBlank(message = "Harcama türü bos olamaz")
    private SpendingType spendingType;
    @NotBlank(message = "Harcama miktarı bos olamaz")
    private int spendingAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;

    private int taxRate;
    @NotBlank(message = "Harcama acıklaması bos olamaz")
    private String spendingDefinition;

    private Long spendingId;


}
