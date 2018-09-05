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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ServletContext context;
    @Override
    public void init(ServletConfig config) throws ServletException {

    context=config.getServletContext();
    }
    public LoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String Username= request.getParameter("username");
		String Password=request.getParameter("password");	
 	HashMap <String,String> users = (HashMap<String,String>)context.getAttribute("usersData");

		if(users.containsKey(Username)) {
			if(users.get(Username).equals(Password)) {
				out.println("<h1> Welcome: " +Username + "</h1>");
			}
			else {
				out.println("<h3>Invalid credentials</h3>");
				out.println("<br></br><a href='Login.html'>TryAgain</a>");
			}
		}
		else {
			out.println("<h3>User does not exist</h3>");
			out.println("<br></br><a href='Login.html'>Try Again</a>");
		}
	
out.close();
}
}

