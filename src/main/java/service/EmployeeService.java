package service;

import java.util.List;		

import exception.ApplicationException;
import pojo.EmployeePojo;

public interface EmployeeService {
	static EmployeePojo addEmployee1(EmployeePojo employeePojo) throws ApplicationException {
		String query = "INSERT INTO employee_details(employee_name, employee_email, user_type, employee_removed) VALUES(?, ?, ?, ?)";
		System.out.println("A new employee was added!");
		return employeePojo;
	}
	static EmployeePojo updateEmployee1(EmployeePojo employeePojo) throws ApplicationException {
		String query = "INSERT INTO employee_details(employee_name, employee_email, user_type, employee_removed) VALUES(?, ?, ?, ?)";
		System.out.println("A new employee was added!");
		return employeePojo;
	}
	EmployeePojo EmployeePojo = null;
	boolean deleteEmployee(int employeeId) throws ApplicationException;
	static List<EmployeePojo> getAllEmployees() throws ApplicationException {
		
		String employeeName = null;
		String employeeId = null;
		
		System.out.println("Employee to be deleted is: " +employeeName+ " , "
				+ "" +employeeId+".");
		String query = "DELETE FROM employee_details WHERE employeeId IN (SELECT employee_id FROM employee_details)";
		System.out.printf("employeeId" , "employeeName"+ "was deleted.");
		return null;
	}
	static EmployeePojo getEmployee(int employeeId) throws ApplicationException {
		String query = "SELECT* FROM employee_details (employee_name, employee_email, user_type, employee_removed) VALUES(?,?,?,?)";
		System.out.println("The employee you requested!");
		return EmployeePojo;
	}
	void exitApplication();
	EmployeePojo updateEmployee(EmployeePojo employeePojo) throws ApplicationException;
	EmployeePojo getAEmployee(int employeeId) throws ApplicationException;
	EmployeePojo addEmployee(EmployeePojo employeePojo) throws ApplicationException; 
}
