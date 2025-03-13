package com.cts.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.demo.model.Employee;
import com.cts.demo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/test")
	public String test() {
		return empService.Welcome();
	}
	@GetMapping("")
	public List<Employee> getAllEmployees(@RequestHeader Map<String, String> headers){
		return empService.getAllEmployees();
	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id, @RequestHeader Map<String, String> headers) {
		return empService.getEmployeeById(id);
	}
	@PostMapping("")
	public Employee addEmployee(@RequestBody Employee emp, @RequestHeader Map<String, String> headers) {
		System.out.println("inside post add");
		return empService.addEmployee(emp);
	}
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable int id, @RequestHeader Map<String, String> headers) {
		return empService.deleteEmployee(id);
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee e, @RequestHeader Map<String, String> headers) {
		return empService.updateEmployee(e);
	}
	
	public void updateHeaders(Map<String, String> headers) {
		headers.forEach((key, value) -> {
	        System.out.printf("Header '%s' = %s%n", key, value);
	    });
	}
	
	
}
