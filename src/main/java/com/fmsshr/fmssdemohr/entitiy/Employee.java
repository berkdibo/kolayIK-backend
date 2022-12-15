package com.fmsshr.fmssdemohr.entitiy;

import com.fmsshr.fmssdemohr.enums.EmployeeDepartment;
import com.fmsshr.fmssdemohr.enums.EmployeeLevel;
import com.fmsshr.fmssdemohr.enums.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", length = 100)
    private  Long userId;

    @Column(name = "name", length = 100)
    private String firstName;

    @Column(name = "last_name",length = 100)
    private String lastName;

    @Column(name = "email",length = 100)
    private String email;


    @Column(name = "identity_no",length = 100)
    private String identityNo;;

    @Column(name = "salary", length = 100)
    private int salary;

    @Column(name = "date_of_start",length = 100)
    private LocalDate startDate;

    @Column(name = "title", length = 100)
    private String title;
    @Enumerated
    @Column(name = "level", length = 100)
    private EmployeeLevel level;
    @Enumerated
    @Column(name = "role",length = 100)
    private EmployeeRole role;
    @Enumerated
    @Column(name = "department", length = 100)
    private EmployeeDepartment department;

    @Column(name = "birth_date",length = 100)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private EmployeeAddress employeeAddress;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<EmployeeExpense> employeeExpense;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<EmployeePermission> employeePermission;







}
