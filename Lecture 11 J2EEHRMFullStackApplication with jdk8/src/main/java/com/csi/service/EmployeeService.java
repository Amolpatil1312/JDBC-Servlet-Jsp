package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {

	public void signUp(Employee employee);

	public boolean signIn(String empEmailId, String empPassword);

	public Employee findById(int empId);

	public List<Employee> findAll();

	public void updateData(int empId, Employee employee);

	public void deleteById(int empId);

	public void deleteAllData();

}
