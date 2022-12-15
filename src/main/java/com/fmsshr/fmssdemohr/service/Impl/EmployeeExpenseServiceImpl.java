package com.fmsshr.fmssdemohr.service.Impl;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdateExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeExpenseResponseDto;
import com.fmsshr.fmssdemohr.entitiy.Employee;
import com.fmsshr.fmssdemohr.entitiy.EmployeeExpense;
import com.fmsshr.fmssdemohr.mapper.SpendingMapper;
import com.fmsshr.fmssdemohr.repository.EmployeeExpenseRepository;
import com.fmsshr.fmssdemohr.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeExpenseServiceImpl implements com.fmsshr.fmssdemohr.service.abstracts.EmployeeExpenseService {

    private final SpendingMapper spendingMapper;
    private final EmployeeExpenseRepository employeeExpenseRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void createExpense(EmployeeExpenseRequestDto employeeExpenseRequestDto) {
        Employee employee = employeeRepository.findById(employeeExpenseRequestDto.getUserId()).orElseThrow(() -> new RuntimeException("not exist"));

    EmployeeExpense expense = spendingMapper.createExpense(employeeExpenseRequestDto);
        expense.setEmployee(employee);
        employeeExpenseRepository.save(expense);

    }

    @Override
    public List<EmployeeExpenseResponseDto> getAllExpenses() {
        List<EmployeeExpense> expenseList= employeeExpenseRepository.findAll();

        return expenseList.stream()
                .map(spendingMapper::createExpenseDto)
                .collect(Collectors.toList());
}

    @Override
    public EmployeeExpenseResponseDto getExpenseById(Long id) {

        Optional<EmployeeExpense> employeeExpense = employeeExpenseRepository.findById(id);

        return employeeExpense.map(spendingMapper::createExpenseDto)
                .orElseThrow(()-> new RuntimeException("expense not exist"));
    }

    @Override
    public void deleteExpenseById(Long id) {

        employeeExpenseRepository.deleteById(id);

    }

    @Override
    public EmployeeExpenseResponseDto updateEmployeeExpenseById(Long id, UpdateExpenseRequestDto updateExpenseRequestDto) {
        Optional<EmployeeExpense> employeeExpenseOptional =employeeExpenseRepository.findById(id);
        employeeExpenseOptional.ifPresent(employeeExpense -> {

            employeeExpense.setReceiptDate(updateExpenseRequestDto.getReceiptDate());
            employeeExpense.setSpendingAmount(updateExpenseRequestDto.getSpendingAmount());
            employeeExpense.setSpendingType(updateExpenseRequestDto.getSpendingType());
            employeeExpense.setSpendingDefinition(updateExpenseRequestDto.getSpendingDefinition());
            employeeExpense.setTaxRate(updateExpenseRequestDto.getTaxRate());

            employeeExpenseRepository.save(employeeExpense);
        });
        return employeeExpenseOptional.map(spendingMapper::createExpenseDto)
                .orElseThrow(()-> new RuntimeException("expense not exist"));
    }
}
