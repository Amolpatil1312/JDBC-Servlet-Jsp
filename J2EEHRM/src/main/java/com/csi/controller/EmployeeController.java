package com.csi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int empId = Integer.valueOf(request.getParameter("empid"));
		String empName = request.getParameter("empname");
		String empAddress = request.getParameter("empaddress");
		double empSalary = Double.valueOf(request.getParameter("empsalary"));
		long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
		String empEmailId = request.getParameter("empemailid");
		String empPassword = request.getParameter("emppassword");

		Employee employee = new Employee(empId, empName, empAddress, empSalary, empContactNumber, empEmailId,
				empPassword);

		EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

		employeeServiceImpl.signUp(employee);

		PrintWriter printWriter = response.getWriter();

		printWriter.println("Signup Done Successfully, Please check data in DB");
		doGet(request, response);
	}

}
