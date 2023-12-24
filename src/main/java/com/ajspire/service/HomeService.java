package com.ajspire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ajspire.DAO.EmployeeDAO;
import com.ajspire.exception.EmployeeNotFoundException;
import com.ajspire.model.Employee;

@Service
public class HomeService {

	@Autowired
	EmployeeDAO dao;

	public String addEmp(Employee emp) {
		dao.save(emp);
		return "Add Record";
	}

	public List<Employee> getData() {
		Iterable<Employee> findAll = dao.findAll();
		return (List<Employee>) findAll;
	}

	public Employee getById(int id) throws EmployeeNotFoundException {
		Employee employee = dao.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found Id : "+id));
		return employee;
	}

	public String deleteById(int id) {
		dao.deleteById(id);
		return "delete Employee : " + id;
	}

	public Employee updateEmployee(Employee emp) {
		Optional<Employee> optional = dao.findById(emp.getEmpId());
		Employee employee = optional.get();
//		String empEmail = emp.getEmpEmail();
//		employee.setEmpEmail(empEmail);
		employee.setEmpEmail(emp.getEmpEmail());//
		employee.setEmpName(emp.getEmpName());
		employee.setEmpSal(emp.getEmpSal());
		Employee savedEmployee = dao.save(employee);
		return savedEmployee;
	}
}
