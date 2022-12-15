package com.fmsshr.fmssdemohr.entitiy;

import com.fmsshr.fmssdemohr.enums.PermissionType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "permission")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class EmployeePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    @Column(name = "permission_type", length = 100)
    private PermissionType permissionType;

    @Column(name = "total_days", length = 100)
    private Long totalDay;

    @Column(name = "start_date", length = 100)
    private LocalDate permissionStartDate;

    @Column(name = "end_date",length = 100)
    private LocalDate permissionEndDate;

    @Column(name = "permission_statement",length = 200)
    private String permissionDefinition;

    @Column(name = "return_date", length = 100)
    private LocalDate permissionReturnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
