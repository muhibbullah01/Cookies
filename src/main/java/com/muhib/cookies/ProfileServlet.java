package com.muhib.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		PrintWriter out = res.getWriter();
		
		String name = "";
		Cookie[] c = req.getCookies();
		if(c == null) {
			out.println(
					"<h1>You are a new user, Kindly LogIn again. </h1>"
					);
			req.getRequestDispatcher("login.html").include(req, res);
		
		}else {
			
			for(Cookie c1 : c) {
				String tempName = c1.getName();
				
				if(tempName.equals("username")) {
					name = c1.getValue();
					out.println(
							"<h1>Welcome to your profile, "+name+"</h1>"
							);
					out.println(
							"<a href='LogoutServlet'>LogOut </a>"
							);
				}
			}
			
		}
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		
		doGet(req, res);
		
	}

}
