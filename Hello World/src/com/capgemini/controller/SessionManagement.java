package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionManagement() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h1>Session Id: " + session.getId() + "</h1>");
		out.println("<h1>Session new or old?: " + session.isNew() + "</h1>");
		Date creationTime = new Date(session.getCreationTime());
		out.println("<h1>Session Creation time: " + creationTime + "</h1>");
		Date lastAccessedTime = new Date(session.getLastAccessedTime());
		out.println("<h1>Session was acccessed last time at : " + lastAccessedTime + "</h1>");
		session.setMaxInactiveInterval(300);
		out.println("<h1>Session timeout period = " + session.getMaxInactiveInterval() + " seconds.");
        session.invalidate();
		
	Cookie c1=new Cookie("MyCookie","www.abc");
		Cookie c2=new Cookie("Message","www.123");
		c1.setMaxAge(1800); 
		c2.setMaxAge(1800);
		 
		
		response.addCookie(c1);
		response.addCookie(c2);
				out.println("<h1><a href='hello'>Hello World</a></h1>");

	
        

	}
}
