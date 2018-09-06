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
	String CardName=request.getParameter("CardName");
	String CardNumber=request.getParameter("CardNumber");
	long CardNum=(long)Integer.parseInt("CardNumber");
	String month=request.getParameter("month");
	int Month=Integer.parseInt("month");
	String Year=request.getParameter("year");
	int year=Integer.parseInt("year");
	String CVV=request.getParameter("CVV");
	int Cvv=Integer.parseInt("cvv");
	
	out.println("CardName: "+CardName+"");
	out.println("CardNumber:"+CardNum+"Month:"+Month+" Year:"+year+" CVV: "+Cvv+"");

out.close();
	}
}
