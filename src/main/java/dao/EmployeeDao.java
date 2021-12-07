package dao;

import java.util.List;			

import exception.ApplicationException;
import pojo.EmployeePojo;

public interface EmployeeDao {
	EmployeePojo addEmployee(EmployeePojo employeePojo) throws ApplicationException;
	EmployeePojo updateEmployee(EmployeePojo employeePojo) throws ApplicationException;
	boolean deleteEmployee(int employeeId) throws ApplicationException;
	List<EmployeePojo> getAllEmployees() throws ApplicationException;
	EmployeePojo getAEmployee(int employeeId) throws ApplicationException;
	void exitApplication();
	EmployeePojo updateemployee(EmployeePojo employeePojo);
	EmployeePojo updateItem(EmployeePojo employeePojo) throws ApplicationException;
	
}
 