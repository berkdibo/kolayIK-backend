package com.fmsshr.fmssdemohr.controller;

import com.fmsshr.fmssdemohr.dtos.request.EmployeePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.request.UpdatePermissionRequestDto;
import com.fmsshr.fmssdemohr.dtos.responseDto.EmployeePermissionResponseDto;
import com.fmsshr.fmssdemohr.service.Impl.EmployeePermissionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/permission")
@AllArgsConstructor
public class EmployeePermissionController {

    private final EmployeePermissionServiceImpl employeePermissionServiceImpl;

    @PostMapping
    public boolean createPermission(@RequestBody EmployeePermissionRequestDto employeePermissionRequestDto){
        employeePermissionServiceImpl.createPermission(employeePermissionRequestDto);
        return true;
    }

    @GetMapping
    public List<EmployeePermissionResponseDto> getAllPermissions(){

        return employeePermissionServiceImpl.getAllPermissions();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeePermissionResponseDto> getPermissionById(@PathVariable Long id){

        return  ResponseEntity.ok(employeePermissionServiceImpl.getPermissionById(id));
    }
    @DeleteMapping("/{id}")
    public void deletePermissionById (@PathVariable Long id){
        employeePermissionServiceImpl.deletePermissionById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeePermissionResponseDto> updateEmployeePermissionById (@PathVariable Long id, @RequestBody UpdatePermissionRequestDto updatePermissionRequestDto){
        return ResponseEntity.ok(employeePermissionServiceImpl.updateEmployeePermissionById(id,updatePermissionRequestDto));
    }




}
