package com.ajspire.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajspire.DAO.EmployeeDAO;
import com.ajspire.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDAO empDao;
	public Employee savem(Employee emp) {
		empDao.save(emp);
		return emp;
		}
	
	public List<Employee> fechdata(){
		Iterable fa = empDao.findAll();
		return (List<Employee>) fa;
		
		
		
	}

}
