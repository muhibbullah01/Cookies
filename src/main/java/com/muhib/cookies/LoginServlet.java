package com.muhib.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("link.html").include(req, res);
		
		String name = req.getParameter("user_name");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("pass", pass);
		
		Cookie c = new Cookie("username", name);
		res.addCookie(c);
		res.sendRedirect("Home");
		
		
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		
		doGet(req, res);
	}

}
