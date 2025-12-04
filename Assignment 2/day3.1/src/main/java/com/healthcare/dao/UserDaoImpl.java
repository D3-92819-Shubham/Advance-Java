package com.healthcare.dao;

import java.sql.*;

import com.healthcare.entities.User;
import com.healthcare.utils.DBUtils;
import static com.healthcare.utils.DBUtils.getConnection;

public class UserDaoImpl implements UserDao {
	// fields
	private Connection cn;
	private PreparedStatement pst1;

	// default constructor
	public UserDaoImpl() throws SQLException {
		// 1. get db connection
		cn = getConnection();
		// 2. create PST - sign in
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("user dao created !");
	}

	@Override
	public void cleanUp() throws SQLException {
		// 1. close pst1
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		if (cn != null) {
			cn.close();
			cn = null;
		}
		System.out.println("user dao cleaned up !");

	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// 1. set IN params
		pst1.setString(1, email);
		pst1.setString(2, password);
		//2. execute the query & process RST
		try(ResultSet rst=pst1.executeQuery()) {			
			if (rst.next())
				return new User(rst.getLong(1),rst.getString(2),rst.getString(3),rst.getDate(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getInt(8),rst.getString(9));			
		}
		
		return null;
	}

}
