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
import pojo.UserPojo;
import presentation.UserMain;

public abstract class UserJdbcDaoImpl implements UserDao {

	private static final Logger logger = LogManager.getLogger(UserJdbcDaoImpl.class);
	
	@Override
	public UserPojo addUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered addUser() in dao.");
		
		// this userPojo does not have an item id set in it.
		//set the user_removed to false
		userPojo.setItemRemoved(false);
		
		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into user_details(user_id, user_name, user_email, user_type, user_removed)" 
							+ "values('"+userPojo.getUserId()+"','"+userPojo.getUserName()
							+"','"+userPojo.getUserEmail()+"',"+userPojo.isUserRemoved()+")";
			
			int rowsAffected = stmt.executeUpdate(query);
			if(rowsAffected != 0) { // means the record got inserted successfully
				// take out the primary key and store in the itemPojo object
				userPojo.setUserId(1);// hard coded to 1 - but later will figure out to fetch the generated
										// primary key from DB
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited addItem() in dao.");
		return userPojo;
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered updateUser() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update user_details set user_type="+userPojo.getUserType()
							+" where user_id="+userPojo.getUserId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited updateUser() in dao.");
		return userPojo;
	}

	@Override
	public boolean deleteUser(int userId) throws ApplicationException {
		logger.info("Entered deleteUser() in dao.");
		
		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going 
			// for a soft delete.
			String query = "update user_details set user_removed=true where user_id="+userId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if(rowsAffected == 0)
			flag = false;
		
		logger.info("Exited deleteuser() in dao.");
		return flag;
	}

	@Override
	public List<UserPojo> getAllUsers() throws ApplicationException {
		logger.info("Entered getAllUsers() in dao.");
		
		// create a empty collection which is going to hold all the records from the DB
		// as pojo Object
		List<UserPojo> allUsersStore = new ArrayList<UserPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from user_details where user_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should get
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a itemPojo object
				UserPojo userPojo = new UserPojo();

				// add the user Pojo object to a collection
				allUsersStore.add(userPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllUsers() in dao.");
		return allUsersStore;
	}

	@Override
	public UserPojo getAUser(int userId) throws ApplicationException {
		logger.info("Entered getAUser() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		UserPojo userPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from user_details where user_id="+userId
							+ "and user_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				userPojo = new UserPojo();
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAUser() in dao.");
		return userPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

	@Override
	public UserPojo updateuser(UserPojo userPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo addUser(int userId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo getAUser(UserPojo userPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userRemoved(int userId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

}
