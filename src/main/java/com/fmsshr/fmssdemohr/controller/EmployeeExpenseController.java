package com.fmsshr.fmssdemohr.controller;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdateExpenseRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeExpenseResponseDto;
import com.fmsshr.fmssdemohr.service.Impl.EmployeeExpenseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/spending")
@AllArgsConstructor
public class EmployeeExpenseController {

    private final EmployeeExpenseServiceImpl employeeExpenseServiceImpl;

    @PostMapping
    public boolean createExpense(@RequestBody EmployeeExpenseRequestDto employeeExpenseRequestDto){
        employeeExpenseServiceImpl.createExpense(employeeExpenseRequestDto);
        return true;


    }
    @GetMapping
    public List<EmployeeExpenseResponseDto> getAllEmployees(){
        return
                employeeExpenseServiceImpl.getAllExpenses();
    }
    @GetMapping("/{spendingId}")
    public ResponseEntity<EmployeeExpenseResponseDto> getExpenseById(@PathVariable Long spendingId){
        return  ResponseEntity.ok(employeeExpenseServiceImpl.getExpenseById(spendingId));


    }
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    public void deleteExpenseById(@PathVariable Long id){
        employeeExpenseServiceImpl.deleteExpenseById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmployeeExpenseResponseDto> updateEmployeeExpenseById (@PathVariable Long id, @RequestBody UpdateExpenseRequestDto updateExpenseRequestDto){
        return ResponseEntity.ok(employeeExpenseServiceImpl.updateEmployeeExpenseById(id, updateExpenseRequestDto));

    }



}
