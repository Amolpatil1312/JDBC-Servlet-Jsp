package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {
	
	void signUp(Employee employee);
	
	boolean signIn(String empEmailId, String empPassword);
	
	List<Employee> findAll();

}
