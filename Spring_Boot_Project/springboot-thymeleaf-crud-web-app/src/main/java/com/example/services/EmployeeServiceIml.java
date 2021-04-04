package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeServiceIml implements EmployeeService{
    
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
	   Optional<Employee> optional = employeeRepository.findById(id); 
	   Employee employee = null;
	   if(optional.isPresent()) {
		   employee = optional.get();
	   }else {
		   throw new RuntimeException("Employee id is not found::"+id);
	   }
	   return employee;
	}

	@Override
	public void deleteEmpById(long id) {
		this.employeeRepository.deleteById(id);
		
	}

}
