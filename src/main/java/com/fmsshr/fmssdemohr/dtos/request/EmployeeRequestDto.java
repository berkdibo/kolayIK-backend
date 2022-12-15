package com.fmsshr.fmssdemohr.dtos.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmsshr.fmssdemohr.enums.EmployeeDepartment;
import com.fmsshr.fmssdemohr.enums.EmployeeLevel;
import com.fmsshr.fmssdemohr.enums.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequestDto {

    private Long userId;

    @NotBlank(message = "Isim bos olamaz!")
    private String firstName;
    @NotBlank(message = "Soyisim bos olamaz!")
    private String lastName;

    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "Email bos olamaz!")
    private String email;

    @Pattern(regexp =  "^[1-9]{1}[0-9]{9}[02468]{1}$")
    @NotBlank(message = "TCK No bos olamaz!")
    private String identityNo;;

    private int salary;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @NotBlank(message = "Unvan bos olamaz!")
    private String title;

    @NotBlank(message = "Role bos olamaz!")
    private EmployeeRole role;
    @NotBlank(message = "Seviye bos olamaz!")
    private EmployeeLevel level;
    @NotBlank(message = "Departman bos olamaz!")
    private EmployeeDepartment department;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @NotBlank(message = "Adres bos olamaz!")
    private String address;
    @NotBlank(message = "Şehir bos olamaz!")
    private String city;
    @NotBlank(message = "Ülke bos olamaz!")

    private String country;

    private int postCode;

    @Pattern(regexp ="^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$")
    @NotBlank(message = "Telefon numarası bos olamaz!")
    private String phoneNumber;



}
