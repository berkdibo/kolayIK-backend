package com.fmsshr.fmssdemohr.service.abstracts;

import com.fmsshr.fmssdemohr.dtos.request.EmployeePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdatePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeePermissionResponseDto;

import java.util.List;

public interface EmployeePermissionService {

    void createPermission(EmployeePermissionRequestDto employeePermissionRequestDto);

    List<EmployeePermissionResponseDto> getAllPermissions();

    EmployeePermissionResponseDto getPermissionById(Long id);

    void deletePermissionById(Long id);


    EmployeePermissionResponseDto updateEmployeePermissionById(Long id, UpdatePermissionRequestDto updatePermissionRequestDto);
}
