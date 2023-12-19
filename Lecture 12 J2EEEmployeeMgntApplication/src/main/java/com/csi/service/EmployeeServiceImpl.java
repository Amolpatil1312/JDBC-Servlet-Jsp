package com.csi.service;

import java.util.List;

import com.csi.dao.EmployeeDao;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.signUp(employee);
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.signIn(empEmailId, empPassword);
	}

	@Override
	public Employee findById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findById(empId);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findAll();
	}

	@Override
	public void updateData(int empId, Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.updateData(empId, employee);
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteById(empId);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteAll();
	}

}
