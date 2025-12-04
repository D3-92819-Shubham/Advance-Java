package com.healthcare.dao;

import java.sql.SQLException;

import com.healthcare.entities.User;

public interface UserDao extends BaseDao {
//add a method user sign in
	User authenticateUser(String email, String password) throws SQLException;
}
