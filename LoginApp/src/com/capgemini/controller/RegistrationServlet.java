package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private HashMap<String,String > users=new HashMap<>();
       private ServletContext context;
       
  
    public RegistrationServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	context=config.getServletContext();
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
				
		PrintWriter out=response.getWriter();
		String Username= request.getParameter("username");
		String Password=request.getParameter("password");		
		
		if(users.containsKey(Username)) {
			out.println("<h3> user already Exists. Please enter another username</h3>");
			out.println("<br></br><a href ='Registration.html'>Try again</a>");
		}
		else {
			users.put(Username, Password);
			out.println("<h3>Registration Succesful. </h3>");
			out.println("<br></br><a href ='Login.html'> Login Here</a>");
			context.setAttribute("usersData", users);

}
		
		out.close();		
		
	}

}
