package com.coconut.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.coconut.model.dto.UserDto;

public interface UserDao {
	public UserDto select(Connection con, String id, String password) throws SQLException;
}
