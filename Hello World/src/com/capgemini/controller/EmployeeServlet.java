package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Employee> employee = new ArrayList<>();

	@Override
	public void init() throws ServletException {
		employee.add(new Employee(1224, "navya", 12000.0, "java"));
		employee.add(new Employee(1232, "mouni", 15000.0, "java"));
		employee.add(new Employee(1245, "akhi", 12000.0, "SAP"));

	}

	public EmployeeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String empnumber = request.getParameter("username");
		int Empnumber = Integer.parseInt(empnumber);
		for (Employee e : employee) {
			if (e.empnumber == Empnumber) {
				out.println("<table border='1' bgcolor='green'<tr><th>Empname</th><th>Empdept</th><th>Salary</th></tr>");
				out.println("<tr><th>" + e.getEmpname() + "</th><th>" + e.getEmpdept()
						+ "</th><th>" + e.getSalary() + "</th></tr></table>");

			}

		}
		out.close();
	}
}
