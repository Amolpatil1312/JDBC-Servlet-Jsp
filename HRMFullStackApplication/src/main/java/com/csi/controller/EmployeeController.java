package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		String redirect = "";

		String empId = request.getParameter("empid");
		String action = request.getParameter("action");

		if (action.equals("signup") && empId != null) {

			int employeeId = Integer.valueOf(empId);
			String empName = request.getParameter("empname");
			String empAddress = request.getParameter("empaddress");
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
			Date empDOBDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				empDOBDate = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empGender = request.getParameter("empgender");

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(employeeId, empName, empAddress, empSalary, empContactNumber, empDOBDate,
					empGender, empEmailId, empPassword);

			employeeServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			if (employeeServiceImpl.signIn(empEmailId, empPassword)) {
				request.setAttribute("empList", employeeServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			} else {

				request.setAttribute("message", "Oops Invalid Credentials, Please try again!!!!!!!!");

				redirect = SIGNIN_PAGE;
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
