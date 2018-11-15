package test.tomcat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import data.session;
import test.tomcat.beans.reimburse;
import test.tomcat.beans.userandpass;

/**
 * Servlet implementation class ToDoServlet1
 */
public class ToDoServlet1 extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -634976360002431745L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().print("Hello to the world wuddup");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("succesfully able to post");
		//Cookie c[]=request.getCookies(); 
		//c.length gives the cookie count 
		//int empid = Integer.parseInt(c[0].getValue());
		int empid = 2;
		session temp = new session();
		reimburse newTodo = new ObjectMapper().readValue(request.getReader(), reimburse.class);
		System.out.println(empid);
		String SQL = "INSERT INTO reimburse VALUES (" + empid + ", " + newTodo.getAmount() + ", 'p', 0)";
		System.out.println(SQL);
		SQL = temp.genericCall(SQL);
		temp.genericCall("commit");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), SQL);
	}

}
