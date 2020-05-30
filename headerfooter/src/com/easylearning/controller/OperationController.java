package com.easylearning.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.easylearning.entity.User;
import com.easylearning.model.UserModel;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Resource(name="dataSource")
	DataSource source;
 
    public OperationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String page=	request.getParameter("page");
	RequestDispatcher rd=null;
	switch(page)
	{
	
	case "userList":
		/*List<User> users=new ArrayList<>();
		UserModel model=new UserModel();
		users=model.listModel(source);
		request.setAttribute("userList", users);
		request.setAttribute("title", "userlist");
		rd=request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);*/
		listUser(source,request,response);
		break;
	case "addUser":
		request.setAttribute("title", "user registration");
		rd=request.getRequestDispatcher("addUser.jsp");
		rd.forward(request, response);
		break;
	case "updateUser":
		updateUser(request,response);
		break;
	case "deleteUser":
		deleteUser(request,response);
		break;
	 default:
		request.setAttribute("title", "error");
		rd=request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);	
	}
		
		
	}
private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		
	RequestDispatcher rd=null;
	UserModel model=new UserModel();
	model.deleteUser(request.getParameter("userId"),source);
	listUser(source, request, response);
	
	}


private void updateUser(HttpServletRequest request,
			HttpServletResponse response) {
		
	RequestDispatcher rd=null;
	try
	{
		rd=request.getRequestDispatcher("updateUser.jsp");
		rd.forward(request, response);
		
	}
	catch(Exception e)
	{
		
	}
	}


public void listUser(DataSource source,HttpServletRequest request,HttpServletResponse response)
{
	RequestDispatcher rd=null;
	List<User> users=new ArrayList<>();
	UserModel model=new UserModel();
	users=model.listModel(source);
	request.setAttribute("userList", users);
	request.setAttribute("title", "userlist");
	rd=request.getRequestDispatcher("userList2.jsp");
	try {
		rd.forward(request, response);
	} catch (ServletException e) { } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return;
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form=request.getParameter("form").toLowerCase();
		RequestDispatcher rd=null;
		
		switch (form) {
		case "adduser":
			String uname=request.getParameter("unmae");
			String email=request.getParameter("email");
			
			User user=new User( uname, email);
			UserModel model=new UserModel();
			model.addUser(user,source);
			listUser(source, request, response);
			
			break;
			
		case "updateuser":
			String userid=request.getParameter("userId");
			String uname2=request.getParameter("unmae");
			String email2=request.getParameter("email");
			
			
			UserModel model2=new UserModel();
			model2.updateUser(userid,uname2,email2,source);
			listUser(source, request, response);
			break;	

		default:
			break;
		}
		
		
	}

}
