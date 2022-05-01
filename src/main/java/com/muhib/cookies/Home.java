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

@WebServlet("/Home")
public class Home extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		PrintWriter out = res.getWriter();
		//req.getRequestDispatcher("link.html").include(req, res);
		HttpSession session = req.getSession();
		String password = (String)session.getAttribute("pass");
		String name = "";
		Cookie[] cookies = req.getCookies();
		
		if(password.equals("1234")) {
			for(Cookie c : cookies) {
				
				String temp = c.getName();
				if(temp.equals("username")) {
					name = c.getValue();
					out.println(
							"<h1>Welcome Home "+name+"! , You've successfully logged In!</h1>"
							);
					out.println(
							"<a href='LogoutServlet'>LogOut |</a>"
							);
					out.println(
							"<a href='ProfileServlet'> Profile </a>"
							);
				}
				
			}
			
			
		}else {
			
			out.println("Sorry invalid user name or password!");
			req.getRequestDispatcher("login.html").include(req, res);
			
		}
		
	}

}
