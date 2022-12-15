package com.fmsshr.fmssdemohr.repository;

import com.fmsshr.fmssdemohr.entitiy.EmployeeExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeExpenseRepository extends JpaRepository<EmployeeExpense,Long> {
}
