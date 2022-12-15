package com.fmsshr.fmssdemohr.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmsshr.fmssdemohr.enums.EmployeeDepartment;
import com.fmsshr.fmssdemohr.enums.EmployeeLevel;
import com.fmsshr.fmssdemohr.enums.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateEmployeeRequestDto {
    private Long userId;

    private String firstName;

    private String lastName;


    private String email;

    private String identityNo;;

    private int salary;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    private String title;

    private EmployeeRole role;

    private EmployeeLevel level;

    private EmployeeDepartment department;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String address;

    private String city;

    private String country;

    private int postCode;

    private String phoneNumber;
}
