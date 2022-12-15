package com.fmsshr.fmssdemohr.service.abstracts;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdateEmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeRequestDto employeeRequestDto);

    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto getById(Long id);

    boolean deleteEmployee(Long id);

    EmployeeResponseDto updateEmployeeById(Long id, UpdateEmployeeRequestDto updateEmployeeRequestDto);
}
