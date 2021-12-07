package dao;

import java.sql.Connection;						
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.EmployeePojo;
import presentation.UserMain;

public class EmployeeJdbcDaoImpl implements EmployeeDao {

	private static final Logger logger = LogManager.getLogger(EmployeeJdbcDaoImpl.class);
	
	@Override
	public EmployeePojo addEmployee(EmployeePojo employeePojo) throws ApplicationException {
		logger.info("Entered addEmployee() in dao.");
		
		// this employeePojo does not have an item id set in it.
		//set the book_removed to false
		employeePojo.setEmployeeRemoved(false);
		
		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into employee_details(employee_id, employee_name, employee_email, user_type, employee_removed)" 
							+ "values('"+employeePojo.getEmployeeId()+"','"+employeePojo.getEmployeeName()
							+"','"+employeePojo.getEmployeeEmail()+"',"+","+employeePojo.isEmployeeRemoved()+")";
			
			int rowsAffected = stmt.executeUpdate(query);
			if(rowsAffected != 0) { // means the record got inserted successfully
				// take out the primary key and store in the itemPojo object
				employeePojo.setEmployeeId(1);// hard coded to 1 - but later will figure out to fetch the generated
										// primary key from DB
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited addItem() in dao.");
		return employeePojo;
	}

	@Override
	public EmployeePojo updateItem(EmployeePojo employeePojo) throws ApplicationException {
		logger.info("Entered updateEmployee() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update employee_details set employee_id="+employeePojo.getEmployeeId()
							+" where employee_id="+employeePojo.getEmployeeId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited updateEmployee() in dao.");
		return employeePojo;
	}

	@Override
	public boolean deleteEmployee(int employeeId) throws ApplicationException {
		logger.info("Entered deleteEmployee() in dao.");
		
		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going 
			// for a soft delete.
			String query = "update employee_details set employee_removed=true where employee_id="+employeeId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if(rowsAffected == 0)
			flag = false;
		
		logger.info("Exited deleteEmployee() in dao.");
		return flag;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		logger.info("Entered getAllEmployees() in dao.");
		
		// create a empty collection which is going to hold all the records from the DB
		// as pojo Object
		List<EmployeePojo> allEmployeesStore = new ArrayList<EmployeePojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from employee_details where employee_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should get
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a itemPojo object
				EmployeePojo employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						query, query, rs.getBoolean(5));

				// add the item Pojo object to a collection
				allEmployeesStore.add(employeePojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllItems() in dao.");
		return allEmployeesStore;
	}

	@Override
	public EmployeePojo getAEmployee(int employeeId) throws ApplicationException {
		logger.info("Entered getAEmployee() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		EmployeePojo employeePojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from employee_details where employee_id="+employeeId
							+ "and employee_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						query, query, rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAEmployee() in dao.");
		return employeePojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

	@Override
	public EmployeePojo updateemployee(EmployeePojo employeePojo) {
		return null;
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) throws ApplicationException {
		return null;
	}

}
