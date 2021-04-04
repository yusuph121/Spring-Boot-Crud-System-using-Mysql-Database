package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Employee;
import com.example.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Display list of Employees
	@GetMapping("/")
	public String viewIndexPage(Model model) {
		model.addAttribute("listEmployee", employeeService.getAllEmployee());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "add_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/updateEmp/{id}")
	public String updateEmp(@PathVariable (value = "id") long id, Model model) {
		//get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employee",employee);
		return "update_employee";
	}
    
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable (value = "id") long id){
		//Call Delete Employee method
		this.employeeService.deleteEmpById(id);
		return "redirect:/";
	}
}
