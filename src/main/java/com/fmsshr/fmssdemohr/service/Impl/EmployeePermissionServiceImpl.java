package com.fmsshr.fmssdemohr.service.Impl;

import com.fmsshr.fmssdemohr.dtos.request.EmployeePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdatePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeePermissionResponseDto;
import com.fmsshr.fmssdemohr.entitiy.EmployeePermission;
import com.fmsshr.fmssdemohr.mapper.PermissionMapper;
import com.fmsshr.fmssdemohr.repository.EmployeePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class EmployeePermissionServiceImpl implements com.fmsshr.fmssdemohr.service.abstracts.EmployeePermissionService {
        private final PermissionMapper permissionMapper;

        private final EmployeePermissionRepository employeePermissionRepository;



    @Override
    public void createPermission(EmployeePermissionRequestDto employeePermissionRequestDto) {

        employeePermissionRepository.save(permissionMapper.createPermission(employeePermissionRequestDto));

    }

    @Override
    public List<EmployeePermissionResponseDto> getAllPermissions() {
        List<EmployeePermission> permissionList = employeePermissionRepository.findAll();
        return permissionList.stream()
                .map(permissionMapper::createPermissionDto)
                .collect(Collectors.toList());

    }

    @Override
    public EmployeePermissionResponseDto getPermissionById(Long id) {

        Optional<EmployeePermission> employeePermission =employeePermissionRepository.findById(id);

        return employeePermission.map(permissionMapper::createPermissionDto)
                .orElseThrow(() -> new RuntimeException("permission not exist"));

    }

    @Override
    public void deletePermissionById(Long id) {
        employeePermissionRepository.deleteById(id);
    }

    @Override
    public EmployeePermissionResponseDto updateEmployeePermissionById(Long id, UpdatePermissionRequestDto updatePermissionRequestDto) {
        Optional<EmployeePermission> employeePermissionOptional = employeePermissionRepository.findById(id);
        employeePermissionOptional.ifPresent(employeePermission->{
            employeePermission.setPermissionDefinition(updatePermissionRequestDto.getPermissionDefinition());
            employeePermission.setPermissionType(updatePermissionRequestDto.getPermissionType());
            employeePermission.setPermissionStartDate(updatePermissionRequestDto.getPermissionStartDate());
            employeePermission.setPermissionEndDate(updatePermissionRequestDto.getPermissionEndDate());
            employeePermission.setPermissionReturnDate(updatePermissionRequestDto.getPermissionReturnDate());
            employeePermission.setTotalDay(updatePermissionRequestDto.getTotalDay());

            employeePermissionRepository.save(employeePermission);

        });
        return  employeePermissionOptional.map(permissionMapper::createPermissionDto)
                .orElseThrow(()-> new RuntimeException("expense not exist"));
}}
