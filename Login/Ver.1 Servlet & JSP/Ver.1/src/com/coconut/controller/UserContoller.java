package com.coconut.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coconut.model.dto.UserDto;
import com.coconut.model.service.UserServiceImpl;

@WebServlet("/user")
public class UserContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("login".equals(action)) {
			login(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserDto user = null;
		
		try {
			user = UserServiceImpl.getImpl().select(id, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user == null) {
			System.out.println("로그인 실패");
			redirect(request, response, "/login.jsp");
		}else {
			System.out.println("로그인 성공");
			redirect(request, response, "/index.jsp");
		}
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
}
