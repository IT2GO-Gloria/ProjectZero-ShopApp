package service;

import java.util.List;					

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserService {

		UserPojo addUser(UserPojo userPojo) throws ApplicationException;
		UserPojo updateUser(UserPojo userPojo) throws ApplicationException;
		List<UserPojo> getAllUsers() throws ApplicationException;
		UserPojo getAUser(int userId) throws ApplicationException;
		void exitApplication(); 
	}