package service;

import java.util.List;		

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.EmployeeDao;
import dao.EmployeeJdbcDaoImpl;
import exception.ApplicationException;
import pojo.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
	
	EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		//this.employeeDao = new employeeDaoImpl();
		this.employeeDao = new EmployeeJdbcDaoImpl();
	}
  
	public EmployeePojo addEmployee1(EmployeePojo employeePojo) throws ApplicationException {
		logger.info("Entered addEmployee() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.addEmployee(employeePojo);
		logger.info("Exited addEmployee() in service.");
		return returnEmployeePojo;
	}

	public EmployeePojo updateEmployee1(EmployeePojo employeePojo) throws ApplicationException {
		logger.info("Entered updateEmployee() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.updateEmployee(employeePojo);
		logger.info("Exited updateEmployee() in service.");
		return returnEmployeePojo;
	}

	@Override
	public boolean deleteEmployee(int employeeId) throws ApplicationException {
		logger.info("Entered deleteEmployee() in service.");
		boolean returnFlag = this.employeeDao.deleteEmployee(employeeId);
		logger.info("Exited deleteEmployee() in service.");
		return returnFlag;
	}

	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		logger.info("Entered getAllEmployees() in service.");
		List<EmployeePojo> allEmployees = this.employeeDao.getAllEmployees();
		logger.info("Exited getAllEmployees() in service.");
		return allEmployees;
	}

	public EmployeePojo getAEmployee1(int employeeId) throws ApplicationException {
		logger.info("Entered getAEmployee() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.getAEmployee(employeeId);
		logger.info("Exited getAEmployee() in service.");
		return returnEmployeePojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		employeeDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}

	@Override
	public EmployeePojo addEmployee(EmployeePojo employeePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo getAEmployee(int employeeId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public pojo.EmployeePojo addEmployee11(pojo.EmployeePojo employeePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
