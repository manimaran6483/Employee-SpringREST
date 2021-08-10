package com.cts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.demo.model.Employee;
	
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
