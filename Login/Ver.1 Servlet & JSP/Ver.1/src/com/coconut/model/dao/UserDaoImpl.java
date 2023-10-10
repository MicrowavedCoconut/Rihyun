package com.coconut.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coconut.model.dto.UserDto;
import com.coconut.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private static UserDaoImpl impl = new UserDaoImpl();
	
	private UserDaoImpl(){
		
	}
	
	public static UserDaoImpl getImpl() {
		return impl;
	}

	@Override
	public UserDto select(Connection con, String id, String password) throws SQLException {
		UserDto user = null;
		String sql = "select * from user where id = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserDto();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
			}
		}finally {
			DBUtil.getUtil().close(pstmt, rs);
		}
		
		return user;
	}
}
