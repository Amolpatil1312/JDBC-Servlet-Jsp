package com.csi.controller;

import java.util.Comparator;
import java.util.Scanner;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;

public class EmployeeController {

	Scanner scanner = new Scanner(System.in);

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	public static void main(String[] args) {

		EmployeeController controller = new EmployeeController();

		// controller.signUp();

		// controller.signIn();

		// controller.getAllData();

		// controller.sortByName();
		// controller.sortBySalary();

		// controller.filterDataBySalary();
		controller.deleteById();

	}

	void signUp() {
		System.out.println("\n Please enter Employee Id, Name, Address, Contact Number, Salary, Email, Password: ");

		int empId = scanner.nextInt();

		String empName = scanner.next();

		String empAddress = scanner.next();

		long empContactNumber = scanner.nextLong();

		double empSalary = scanner.nextDouble();

		String empEmailId = scanner.next();

		String empPassword = scanner.next();

		Employee employee = new Employee(empId, empName, empAddress, empContactNumber, empSalary, empEmailId,
				empPassword);

		employeeServiceImpl.signUp(employee);

	}

	void signIn() {
		System.out.println("\n Please enter Emp Email Id & Emp Password: ");

		String empEmailId = scanner.next();

		String empPassword = scanner.next();

		if (employeeServiceImpl.signIn(empEmailId, empPassword)) {
			System.out.println("WELCOME TO FINTECH");
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	void getAllData() {
		employeeServiceImpl.getAllData().forEach(System.out::println);
	}

	void sortByName() {
		employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName).reversed())
				.forEach(System.out::println);
	}

	void sortBySalary() {
		employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary))
				.forEach(System.out::println);
	}

	void filterDataBySalary() {
		employeeServiceImpl.getAllData().stream().filter(emp -> emp.getEmpSalary() >= 50000.00)
				.forEach(System.out::println);
	}

	void deleteById() {
		employeeServiceImpl.deleteById(111);
	}

}
