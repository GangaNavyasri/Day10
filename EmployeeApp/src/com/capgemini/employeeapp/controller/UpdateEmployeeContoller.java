package com.capgemini.employeeapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;

@WebServlet("/updateEmployee")
public class UpdateEmployeeContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
    private ServletContext context;
    
    public UpdateEmployeeContoller() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	
    		context = config.getServletContext();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		String id = request.getParameter("id");
		request.setAttribute("employeeDao", employeeDao.findEmployeeById(Integer.parseInt(id)));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployee.jsp");
		dispatcher.forward(request, response);
	
	
	}

}
