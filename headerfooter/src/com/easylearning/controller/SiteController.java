package com.easylearning.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SiteController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=null;
		String page=request.getParameter("page");
		switch (page) {
		case "home":
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		
		default:
			
			rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			break;
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
