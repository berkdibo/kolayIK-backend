package com.fmsshr.fmssdemohr.dtos.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmsshr.fmssdemohr.enums.PermissionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
@Getter
@Setter

public class EmployeePermissionResponseDto {
    private Long userId;

    private PermissionType permissionType;

    private Long totalDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate permissionStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate permissionEndDate;

    private String permissionDefinition;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate permissionReturnDate;

    private Long permissionId;
}
