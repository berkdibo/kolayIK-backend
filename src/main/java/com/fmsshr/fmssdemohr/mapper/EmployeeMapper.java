package com.fmsshr.fmssdemohr.mapper;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeResponseDto;
import com.fmsshr.fmssdemohr.entitiy.Employee;
import com.fmsshr.fmssdemohr.entitiy.EmployeeAddress;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee dtoToEntity(EmployeeRequestDto employeeRequestDto){
        Employee employee = new Employee();
        EmployeeAddress employeeAddress = new EmployeeAddress();

        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setIdentityNo(employeeRequestDto.getIdentityNo());
        employee.setSalary(employeeRequestDto.getSalary());
        employee.setStartDate(employeeRequestDto.getStartDate());
        employee.setTitle(employeeRequestDto.getTitle());
        employee.setRole(employeeRequestDto.getRole());
        employee.setLevel(employeeRequestDto.getLevel());
        employee.setDepartment(employeeRequestDto.getDepartment());
        employee.setBirthDate(employeeRequestDto.getBirthDate());

        employeeAddress.setAddress(employeeRequestDto.getAddress());
        employeeAddress.setCountry(employeeAddress.getCountry());
        employeeAddress.setCity(employeeAddress.getCity());
        employeeAddress.setPhoneNumber(employeeRequestDto.getPhoneNumber());
        employeeAddress.setPostCode(employeeRequestDto.getPostCode());
        employeeAddress.setEmployee(employee);
        employee.setEmployeeAddress(employeeAddress);


        return employee;

    }
    public EmployeeResponseDto employeeToDto(Employee employee){
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();



        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setEmail(employee.getEmail());
        employeeResponseDto.setIdentityNo(employee.getIdentityNo());
        employeeResponseDto.setSalary(employee.getSalary());
        employeeResponseDto.setStartDate(employee.getStartDate());
        employeeResponseDto.setTitle(employee.getTitle());
        employeeResponseDto.setRole(employee.getRole());
        employeeResponseDto.setLevel(employee.getLevel());
        employeeResponseDto.setDepartment(employee.getDepartment());
        employeeResponseDto.setBirthDate(employee.getBirthDate());

        employeeResponseDto.setPhoneNumber(employee.getEmployeeAddress().getPhoneNumber());
        employeeResponseDto.setCity(employee.getEmployeeAddress().getCity());
        employeeResponseDto.setCountry(employee.getEmployeeAddress().getCountry());
        employeeResponseDto.setPostCode(employee.getEmployeeAddress().getPostCode());
        employeeResponseDto.setUserId(employee.getUserId());




        return employeeResponseDto;
    }


}
