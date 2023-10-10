package com.coconut.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.coconut.model.dao.UserDaoImpl;
import com.coconut.model.dto.UserDto;
import com.coconut.util.DBUtil;

public class UserServiceImpl implements UserService{
	private static UserServiceImpl impl = new UserServiceImpl();
	
	private UserServiceImpl() {
		
	}
	
	public static UserServiceImpl getImpl() {
		return impl;
	}

	@Override
	public UserDto select(String id, String password) throws SQLException {
		Connection con = null;
		try {
			con = DBUtil.getUtil().getConnection();
			return UserDaoImpl.getImpl().select(con, id, password);
		} finally {
			DBUtil.getUtil().close(con);
		}
	}

}
