package com.fmsshr.fmssdemohr.repository;

import com.fmsshr.fmssdemohr.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
