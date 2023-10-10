package com.coconut.model.service;

import java.sql.SQLException;

import com.coconut.model.dto.UserDto;

public interface UserService {
	public UserDto select(String id, String password) throws SQLException;
}
