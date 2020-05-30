package com.easylearning.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/TestConnection")
public class TestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="dataSource")
    DataSource source;
    public TestConnection() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		String username="";
		int user_id=0;
		String email_id="";
		
		try {
			con=source.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from users");
			while(rs.next())
			{
				user_id=rs.getInt(1);
				username=rs.getString(2);
				System.out.println(username);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", username);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
