package com.fmsshr.fmssdemohr.mapper;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeExpenseResponseDto;
import com.fmsshr.fmssdemohr.entitiy.Employee;
import com.fmsshr.fmssdemohr.entitiy.EmployeeExpense;
import org.springframework.stereotype.Component;

@Component
public class SpendingMapper{

    public EmployeeExpense createExpense(EmployeeExpenseRequestDto employeeExpenseRequestDto){


        return   EmployeeExpense.builder()
                    .employee(Employee.builder().userId(employeeExpenseRequestDto.getUserId()).build())
                    .spendingType(employeeExpenseRequestDto.getSpendingType())
                    .spendingAmount(employeeExpenseRequestDto.getSpendingAmount())
                    .spendingDefinition(employeeExpenseRequestDto.getSpendingDefinition())
                    .receiptDate(employeeExpenseRequestDto.getReceiptDate())
                    .taxRate(employeeExpenseRequestDto.getTaxRate())
                .build();
    }

    public EmployeeExpenseResponseDto createExpenseDto(EmployeeExpense employeeExpense){
        EmployeeExpenseResponseDto expenseResponseDto = new EmployeeExpenseResponseDto();
        expenseResponseDto.setUserId(employeeExpense.getEmployee().getUserId());
        expenseResponseDto.setSpendingType(employeeExpense.getSpendingType());
        expenseResponseDto.setSpendingAmount(employeeExpense.getSpendingAmount());
        expenseResponseDto.setReceiptDate(employeeExpense.getReceiptDate());
        expenseResponseDto.setTaxRate(employeeExpense.getTaxRate());
        expenseResponseDto.setSpendingDefinition(employeeExpense.getSpendingDefinition());
        expenseResponseDto.setSpendingId(employeeExpense.getId());
        return expenseResponseDto;
    }

}
