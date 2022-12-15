package com.fmsshr.fmssdemohr.service.abstracts;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdateExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeExpenseResponseDto;

import java.util.List;

public interface EmployeeExpenseService {

    void createExpense(EmployeeExpenseRequestDto employeeExpenseRequestDto);

    List<EmployeeExpenseResponseDto> getAllExpenses();

    EmployeeExpenseResponseDto getExpenseById(Long id);


    void deleteExpenseById(Long id);


    EmployeeExpenseResponseDto updateEmployeeExpenseById(Long id, UpdateExpenseRequestDto updateExpenseRequestDto);
}
