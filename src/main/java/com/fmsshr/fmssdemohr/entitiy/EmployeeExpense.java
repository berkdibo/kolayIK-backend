package com.fmsshr.fmssdemohr.entitiy;

import com.fmsshr.fmssdemohr.enums.SpendingType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class EmployeeExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    @Column(name = "expense_type", length = 100)
    private SpendingType spendingType;

    @Column(name = "spending_amount", length = 100)
    private int spendingAmount;

    @Column(name = "receipt_date", length = 100)
    private LocalDate receiptDate;

    @Column(name = "spending_statement", length = 200)
    private String spendingDefinition;

    @Column(name = "tax_rate",length = 200)
    private int taxRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
