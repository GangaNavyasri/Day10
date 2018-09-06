package com.capgemini.controller;

public class Employee {
  int empnumber;
  String empname;
  double Salary;
  String empdept;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int empnumber, String empname, double salary, String empdept) {
	super();
	this.empnumber = empnumber;
	this.empname = empname;
	Salary = salary;
	this.empdept = empdept;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public double getSalary() {
	return Salary;
}
public void setSalary(double salary) {
	Salary = salary;
}
public String getEmpdept() {
	return empdept;
}
public void setEmpdept(String empdept) {
	this.empdept = empdept;
}
  
}
