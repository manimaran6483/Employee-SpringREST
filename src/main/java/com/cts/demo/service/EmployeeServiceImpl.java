package com.cts.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.demo.model.Employee;
import com.cts.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees(){
		if(empRepo.findAll().size()==0) {
			empRepo.save(new Employee("Manimaran",22,25000,"Male"));
			empRepo.save(new Employee("Tharun",22,65000,"Male"));
			empRepo.save(new Employee("Mihilan",22,20000,"Male"));
			empRepo.save(new Employee("Simran",21,55000,"Female"));
		}
		return empRepo.findAll();
	}
	public Employee deleteEmployee(int id) {
		Employee emp = empRepo.findById(id).get();
		empRepo.deleteById(id);
		return emp;
	}
	public Employee addEmployee(Employee e)
	{
		Employee emp = new Employee();
		emp.setAge(e.getAge());
		emp.setGender(e.getGender());
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		return empRepo.save(emp);
	}
	public Employee updateEmployee(Employee e) {
		 Employee emp = empRepo.findById(e.getId()).get();
		 emp.setAge(e.getAge());
		 emp.setGender(e.getGender());
		 emp.setName(e.getName());
		 emp.setSalary(e.getSalary());
		 empRepo.save(emp);
		 return emp;
	}
	public Employee getEmployeeById(int id) {
		return empRepo.findById(id).get();
	}
	@Override
	public String Welcome() {
		// TODO Auto-generated method stub
		return "Welcome";
	}
	
	

}
