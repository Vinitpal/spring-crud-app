package com.crudapp.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.crudapp.business.model.Employee;
import com.crudapp.business.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// display employees list
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	// show new employee page
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	// add new employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	// update employee page
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id, Model model) {

		// get Employee from service
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as a model attribute to pre-populate form
		model.addAttribute("employee", employee);
		return "update_employee";		
	}
	
	// delete employee
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") long id) {
		
		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
