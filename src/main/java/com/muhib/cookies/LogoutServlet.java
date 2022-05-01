package com.muhib.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("link.html").include(req, res);
		Cookie c = new Cookie("username", "");
		c.setMaxAge(0);
		res.addCookie(c);
		out.println("<h1>You Have Logged Out Successfully! "
				+ "To Login Again Please Re-Enter Your Username & Password</h1>");
		req.getRequestDispatcher("login.html").include(req, res);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		
				doGet(req, res);
		
			}

}
