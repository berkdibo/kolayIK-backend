package com.fmsshr.fmssdemohr.controller;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdateEmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeResponseDto;
import com.fmsshr.fmssdemohr.service.Impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @PostMapping
    public boolean createEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto){
          employeeServiceImpl.createEmployee(employeeRequestDto);
        return true;
    }

    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return  employeeServiceImpl.getAllEmployees();


    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(employeeServiceImpl.getById(id));


    }


    @DeleteMapping("/{userId}")
    public void deleteEmployee(@PathVariable Long userId){
        employeeServiceImpl.deleteEmployee(userId);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployeeById (@PathVariable Long id, @RequestBody UpdateEmployeeRequestDto updateEmployeeRequestDto){
        return ResponseEntity.ok(employeeServiceImpl.updateEmployeeById(id, updateEmployeeRequestDto));
    }




    }
