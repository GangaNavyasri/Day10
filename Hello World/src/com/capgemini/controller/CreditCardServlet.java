package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreditCard")
public class CreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreditCardServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String CardName=request.getParameter("nameoncard");
	String CardNumber=request.getParameter("cardnumber");
	String month=request.getParameter("month");
	String year=request.getParameter("year");
	String CVV=request.getParameter("CVV");
	
	
	out.println("<h3>CardName: "+CardName+"<br>CardNumber:"+CardNumber+"<br>Month/Year: "+month+year);

out.close();
	}
}
