package com.fmsshr.fmssdemohr.service.Impl;

import com.fmsshr.fmssdemohr.dtos.request.EmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdateEmployeeRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeeResponseDto;
import com.fmsshr.fmssdemohr.entitiy.Employee;
import com.fmsshr.fmssdemohr.mapper.EmployeeMapper;
import com.fmsshr.fmssdemohr.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements com.fmsshr.fmssdemohr.service.abstracts.EmployeeService {

   private final EmployeeRepository employeeRepository;
   private final EmployeeMapper employeeMapper;
   @Override
   public void createEmployee(EmployeeRequestDto employeeRequestDto) {

      employeeRepository.save(employeeMapper.dtoToEntity(employeeRequestDto));
   }

   public List<EmployeeResponseDto> getAllEmployees(){
       return StreamSupport.stream(employeeRepository.findAll().spliterator(),true).map(employeeMapper::employeeToDto).collect(Collectors.toList());
   }

   public EmployeeResponseDto getById(Long id){
       Optional<Employee> employee = employeeRepository.findById(id);
       return employee.map(employeeMapper::employeeToDto).orElseThrow(()-> new RuntimeException());

   }

   @Override
   public boolean deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
       return true;
   }

    @Override
    public EmployeeResponseDto updateEmployeeById(Long id, UpdateEmployeeRequestDto updateEmployeeRequestDto) {

       Optional<Employee> employeeOptional = employeeRepository.findById(id);

       employeeOptional.ifPresent(employee ->{
           employee.setFirstName(updateEmployeeRequestDto.getFirstName());
           employee.setLastName(updateEmployeeRequestDto.getLastName());
           employee.setEmail(updateEmployeeRequestDto.getEmail());
           employee.setIdentityNo(updateEmployeeRequestDto.getIdentityNo());
           employee.setSalary(updateEmployeeRequestDto.getSalary());
           employee.setTitle(updateEmployeeRequestDto.getTitle());
           employee.setRole(updateEmployeeRequestDto.getRole());
           employee.setLevel(updateEmployeeRequestDto.getLevel());
           employee.setDepartment(updateEmployeeRequestDto.getDepartment());
           employee.setStartDate(updateEmployeeRequestDto.getStartDate());
           employee.setBirthDate(updateEmployeeRequestDto.getBirthDate());
           employeeRepository.save(employee);




    });
       return employeeOptional.map(employeeMapper::employeeToDto).orElseThrow(()-> new RuntimeException("employee not exist"));

    }}
