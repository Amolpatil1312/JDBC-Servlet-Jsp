package com.csi.controller;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.lang.invoke.StringConcatFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
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

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	public static final String SIGNUP_PAGE = "/signup.jsp";

	public static final String SIGNIN_PAGE = "/signin.jsp";

	public static final String SHOWDATA_PAGE = "/show.jsp";

	public static final String EDITDATA_PAGE = "/edit.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
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

		String redirect = "";

		String employeeId = request.getParameter("empid");

		String action = request.getParameter("action");

		if (null != employeeId && action.equals("signup")) {

			int empId = Integer.valueOf(employeeId);
			String empName = request.getParameter("empname");
			String empAddress = request.getParameter("empaddress");
			String empState = request.getParameter("empstate");
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
			String empGender = request.getParameter("empgender");
			Date empDOB = null;

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				empDOB = dateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empDept = "";

			String depts[] = request.getParameterValues("empdept");

			for (int i = 0; i < depts.length; i++) {
				empDept += depts[i] + " ";
			}

			long empUID = Long.valueOf(request.getParameter("empuid"));

			String empPanCard = request.getParameter("emppancard");

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empId, empName, empAddress, empState, empSalary, empContactNumber,
					empGender, empDOB, empDept, empUID, empPanCard, empEmailId, empPassword);

			employeeServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			if (employeeServiceImpl.signIn(empEmailId, empPassword)) {

				request.setAttribute("empList", employeeServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Oops Please try again!!!!!!");

				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {

			redirect = EDITDATA_PAGE;

		} else if (action.equals("edit")) {

			int empId = Integer.valueOf(request.getParameter("empid"));
			String empName = request.getParameter("empname");
			String empAddress = request.getParameter("empaddress");
			String empState = request.getParameter("empstate");
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
			String empGender = request.getParameter("empgender");
			Date empDOB = null;

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				empDOB = dateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empDept = "";

			String depts[] = request.getParameterValues("empdept");

			for (int i = 0; i < depts.length; i++) {
				empDept += depts[i] + " ";
			}

			long empUID = Long.valueOf(request.getParameter("empuid"));

			String empPanCard = request.getParameter("emppancard");

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empId, empName, empAddress, empState, empSalary, empContactNumber,
					empGender, empDOB, empDept, empUID, empPanCard, empEmailId, empPassword);

			employeeServiceImpl.updateData(empId, employee);

			request.setAttribute("empList", employeeServiceImpl.findAll());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletebyid")) {

			int empId = Integer.valueOf(request.getParameter("empid"));

			employeeServiceImpl.deleteById(empId);

			request.setAttribute("empList", employeeServiceImpl.findAll());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deleteall")) {

			employeeServiceImpl.deleteAll();

			request.setAttribute("empList", employeeServiceImpl.findAll());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyid")) {

			int empId = Integer.valueOf(request.getParameter("empid"));
			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpId() == empId).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyname")) {

			String empName = request.getParameter("empname");
			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpName().equals(empName)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbycontactnumber")) {

			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpContactNumber() == empContactNumber).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyemailid")) {

			String empEmailId = request.getParameter("empemailid");

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbydob")) {

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			String empDOBDateUI = request.getParameter("empdob");

			
			 
			request.setAttribute("empList", employeeServiceImpl.findAll().stream().filter(emp-> dateFormat.format(emp.getEmpDOB()).equals(empDOBDateUI)).collect(Collectors.toList()));
			 
			/*
			 * System.out.println("UI DATE: " + empDOBDateUI);
			 * 
			 * 
			 * List<Employee> empList = new ArrayList<Employee>();
			 * 
			 * for (Employee employee : employeeServiceImpl.findAll()) {
			 * 
			 * //System.out.println("DB DATE: " + dateFormat.format(employee.getEmpDOB()));
			 * 
			 * 
			 * if(dateFormat.format(employee.getEmpDOB()).equals(empDOBDateUI)) {
			 * 
			 * empList.add(employee);
			 * 
			 * } }
			 * 
			 * request.setAttribute("empList", empList);
			 */

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbydept")) {

			

		String empDept = "";

			String depts = request.getParameter("empdept");

			/*
			 * for (int i = 0; i < depts.length; i++) { empDept += depts[i] + " "; }
			 */

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpDept().contains(depts)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbystate")) {

			String empState = request.getParameter("empstate");
			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpState().equals(empState)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyanyinput")) {

			String anyInput = request.getParameter("anyinput");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> String.valueOf(emp.getEmpId()).equals(anyInput) || emp.getEmpDept().equals(anyInput)
							|| emp.getEmpName().equals(anyInput) || emp.getEmpAddress().equals(anyInput)
							|| emp.getEmpState().equals(anyInput)
							|| String.valueOf(emp.getEmpContactNumber()).equals(anyInput)
							|| emp.getEmpPanCard().equals(anyInput) || emp.getEmpEmailId().equals(anyInput)
							|| dateFormat.format(emp.getEmpDOB()).equals(anyInput))
					.collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyuid")) {

			Long empUID = Long.valueOf(request.getParameter("empuid"));

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpUID() == (empUID)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbypancard")) {

			String empPanCard = request.getParameter("emppancard");

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpPanCard().equals(empPanCard)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;
		} else if (action.equals("sortbyid")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbysalary")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbydob")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Employee::getEmpDOB)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbygender")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Employee::getEmpGender)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbystate")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Employee::getEmpState)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbydept")) {

			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Employee::getEmpDept)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbysalary")) {

			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			request.setAttribute("empList", employeeServiceImpl.findAll().stream()
					.filter(emp -> emp.getEmpSalary() >= empSalary).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("checkloaneligibility")) {

			int empId = Integer.valueOf(request.getParameter("empid"));

			boolean flag = false;

			for (Employee employee : employeeServiceImpl.findAll()) {
				if (employee.getEmpId() == empId && employee.getEmpSalary() >= 30000.00) {
					request.setAttribute("message", "Yes! YOU ARE ELIGIBLE FOR LOAN");

					flag = true;
					break;
				}
			}
			if (!flag) {
				request.setAttribute("message", "No! YOU ARE NOT ELIGIBLE FOR LOAN");
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);

		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
