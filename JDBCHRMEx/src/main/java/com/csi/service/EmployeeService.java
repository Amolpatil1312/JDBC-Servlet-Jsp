package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {

	void signUp(Employee employee);

	boolean signIn(String empEmailId, String empPassword);

	List<Employee> getAllData();
	
	void deleteById(int empId);

}
