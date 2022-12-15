package com.fmsshr.fmssdemohr.mapper;

import com.fmsshr.fmssdemohr.dtos.request.EmployeePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeePermissionResponseDto;
import com.fmsshr.fmssdemohr.entitiy.Employee;
import com.fmsshr.fmssdemohr.entitiy.EmployeePermission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {

    public EmployeePermission createPermission(EmployeePermissionRequestDto employeePermissionRequestDto){
        return EmployeePermission.builder().employee(Employee.builder().userId(employeePermissionRequestDto.getUserId()).build())
                .permissionDefinition(employeePermissionRequestDto.getPermissionDefinition())
                .permissionType(employeePermissionRequestDto.getPermissionType())
                .permissionEndDate(employeePermissionRequestDto.getPermissionEndDate())
                .permissionStartDate(employeePermissionRequestDto.getPermissionStartDate())
                .permissionReturnDate(employeePermissionRequestDto.getPermissionReturnDate()).build();

    }
    public EmployeePermissionResponseDto createPermissionDto(EmployeePermission employeePermission){
        EmployeePermissionResponseDto permissionResponseDto = new EmployeePermissionResponseDto();
        permissionResponseDto.setUserId(employeePermission.getEmployee().getUserId());
        permissionResponseDto.setPermissionDefinition(employeePermission.getPermissionDefinition());
        permissionResponseDto.setPermissionType(employeePermission.getPermissionType());
        permissionResponseDto.setPermissionStartDate(employeePermission.getPermissionStartDate());
        permissionResponseDto.setPermissionEndDate(employeePermission.getPermissionEndDate());
        permissionResponseDto.setTotalDay(employeePermission.getTotalDay());
        permissionResponseDto.setPermissionReturnDate(employeePermission.getPermissionReturnDate());
        permissionResponseDto.setPermissionId(employeePermission.getId());
        return  permissionResponseDto;


    }
}
