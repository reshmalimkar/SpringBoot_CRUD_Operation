package com.ajspire.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajspire.model.Employee;
@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

}
