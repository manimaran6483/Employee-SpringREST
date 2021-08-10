package com.cts.demo.service;

import java.util.List;
import com.cts.demo.model.Employee;
public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee deleteEmployee(int id);
	public Employee addEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public String Welcome();
}
