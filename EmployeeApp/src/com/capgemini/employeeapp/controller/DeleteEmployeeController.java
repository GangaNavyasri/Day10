package com.capgemini.employeeapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.model.Employee;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private ServletContext context;

	@Override
	public void init(ServletConfig config) throws ServletException {

		context = config.getServletContext();
	}

	public DeleteEmployeeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		String id = request.getParameter("id");
		employeeDao.deleteEmployee(Integer.parseInt(id));
		List<Employee> employees = employeeDao.findAllEmployees();
		request.setAttribute("employeesList", employees);
		context.setAttribute("employeeDao", employeeDao);

		RequestDispatcher dispatcher = request.getRequestDispatcher("getAllEmployees");
		dispatcher.forward(request, response);

	}

}
