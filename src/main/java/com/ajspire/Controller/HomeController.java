package com.ajspire.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajspire.exception.EmployeeNotFoundException;
import com.ajspire.model.Employee;
import com.ajspire.service.HomeService;

@RestController
public class HomeController {

	@Autowired
	HomeService service;

	@PostMapping(value = "/add")
	public String addEmp(@RequestBody Employee emp) {
		String msg = service.addEmp(emp);
		return msg;

	}

	@GetMapping(value = "fetchAll")
	public List<Employee> getAllData() {
		List<Employee> data = service.getData();
		return data;
	}

	@GetMapping(value = "fetchById/{test}")
	public Employee getEmployeeById(@PathVariable("test") int city) throws EmployeeNotFoundException {
		Employee employee = service.getById(city);
		
		return employee;
	}

	@ExceptionHandler( value =EmployeeNotFoundException.class)
	public String handleException(EmployeeNotFoundException ex) {
		return ex.getMessage();
	}

	@GetMapping(value = "fetchById")
	public Employee getEmployeeByIdUsingRequestParam(@RequestParam("test") int city) throws EmployeeNotFoundException {
		Employee employee = service.getById(city);
		return employee;
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deleteById(@PathVariable("id") int id) {
		String deleteById = service.deleteById(id);
		return deleteById;
	}

	@PutMapping(value = "/updatedEmp")
	public Employee updateEmp(@RequestBody Employee emp) {
		Employee updateEmployee = service.updateEmployee(emp);
		return updateEmployee;

	}
}
