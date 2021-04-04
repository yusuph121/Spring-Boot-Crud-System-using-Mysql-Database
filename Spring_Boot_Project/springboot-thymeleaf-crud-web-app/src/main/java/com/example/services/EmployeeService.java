package com.example.services;

import java.util.List;
import com.example.model.Employee;

public interface EmployeeService {
    //Get All Employee Data
	List<Employee> getAllEmployee(); 
	
	//Save Employee Details
	void saveEmployee(Employee employee);
	
	//Update Employee Details
	Employee getEmployeeById(long id);
	
	//Delete Employee By Id
	void deleteEmpById(long id);
}
