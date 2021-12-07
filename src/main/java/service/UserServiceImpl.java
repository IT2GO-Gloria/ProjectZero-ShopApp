package service;

import org.apache.logging.log4j.LogManager;				
import org.apache.logging.log4j.Logger;
import dao.UserDao;
import dao.UserJdbcDaoImpl;
import exception.ApplicationException;
import pojo.UserPojo;

public class UserServiceImpl implements UserService  {
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	UserDao userDao;
	
	public UserServiceImpl() {
	}
	public UserPojo register(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered register() in service.");
		UserPojo returnedUserPojo = register(userPojo);
		logger.info("Exited register() in service.");
		return returnedUserPojo;	
	}
	public UserPojo validateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in service.");
		UserPojo returnedUserPojo = ((UserServiceImpl) this.userDao).validateUser(userPojo);
		logger.info("Exited validateUser() in service.");
		return returnedUserPojo;	
	}
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		userDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}
	@Override
	public boolean deleteUser(int userId) throws ApplicationException {
		
		return true;
	}
	@Override
	public UserPojo updateuser(UserPojo userPojo) throws ApplicationException {
		
		return null;
	}
	@Override
	public UserPojo getAUser1(int userId) throws ApplicationException {
		
		return null;
	}
	@Override
	public UserPojo getUser(int userId) throws ApplicationException {
		
		return null;
	}
	@Override
	public UserPojo adduser1(UserPojo userPojo) throws ApplicationException {
		
		return null;
	}
	@Override
	public UserPojo updateUser1(UserPojo userPojo) throws ApplicationException {
		
		return null;
	}
	@Override
	public UserPojo getUser1(int userId) throws ApplicationException {
		
		return null;
	}
}
