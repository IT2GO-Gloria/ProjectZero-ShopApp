package dao;

import java.util.List;					

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserDao {
	UserPojo addUser(int userId) throws ApplicationException;
	UserPojo updateUser(UserPojo userPojo) throws ApplicationException;
	boolean userRemoved(int userId) throws ApplicationException;
	List<UserPojo> getAllUsers() throws ApplicationException;
	UserPojo getAUser(UserPojo userPojo) throws ApplicationException;
	void exitApplication();
	UserPojo updateuser(UserPojo userPojo);
	boolean deleteUser(int userId) throws ApplicationException;
	UserPojo addUser(UserPojo userPojo) throws ApplicationException;
	UserPojo getAUser(int userId) throws ApplicationException;
	boolean deleteItem(int userId) throws ApplicationException;
	
}
 