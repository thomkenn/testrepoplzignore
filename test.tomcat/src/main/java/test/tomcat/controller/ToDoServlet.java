package test.tomcat.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.tomcat.beans.Todo;
import test.tomcat.beans.userandpass;

import data.session;

public class ToDoServlet extends HttpServlet{

	private static final long serialVersionUID = -8784759937789970696L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//userandpass todo = new userandpass();
		/*
		todo.setName("Clean Room");
		todo.setPriority(0);
		*/
		/*
		int i = Integer.parseInt(req.getParameter("id"));
		
		if (i >= 10)
		{
			res.setStatus(404);
			return;
		}
		*/
		
		
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("empid"));
		
		userandpass todo = new userandpass();
		String temptint = req.getParameter("\"empid\"");
		todo.setUsername(req.getParameter("username="));
		todo.setPassword(req.getParameter("password"));
		if (temptint != null) todo.setEmpid(Integer.parseInt(temptint));
		else todo.setEmpid(2);
		ObjectMapper mapper = new ObjectMapper();
		res.setHeader("Content-Type", "application/json");
		mapper.writeValue(res.getOutputStream(), todo);
		
		/*
		String data = "Hello World!";
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(data);
		*/
		

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		userandpass newTodo = new ObjectMapper().readValue(req.getReader(), userandpass.class);
		System.out.println(newTodo);
		
		session temp = new session();
		int empid = temp.attemptLogin(newTodo);
		newTodo.setEmpid(empid);
		System.out.println(newTodo);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(res.getOutputStream(), newTodo);
		
		String id = "" + newTodo.getEmpid();
		Cookie c = new Cookie("userid", id);
		c.setMaxAge(1800);
		res.addCookie(c);
	}	
	
}
