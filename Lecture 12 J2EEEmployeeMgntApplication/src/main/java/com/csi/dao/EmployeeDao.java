package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {
	
	void signUp(Employee employee);
	
	boolean signIn(String empEmailId, String empPassword);
	
	Employee findById(int empId);
	
	List<Employee> findAll();
	
	void updateData(int empId, Employee employee);
	
	void deleteById(int empId);
	
	void deleteAll();

}
