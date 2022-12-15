package com.fmsshr.fmssdemohr.dtos.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmsshr.fmssdemohr.enums.PermissionType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter

public class EmployeePermissionRequestDto {
    private Long userId;
    @NotBlank(message = "Harcama türü bos olamaz")
    private PermissionType permissionType;


    private Long totalDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate permissionStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate permissionEndDate;
    @NotBlank(message = "İzin acıklaması  bos olamaz")
    private String permissionDefinition;
    @NotBlank(message = "Dönüş tarihi bos olamaz")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate permissionReturnDate;

    private Long permissionId;
}
