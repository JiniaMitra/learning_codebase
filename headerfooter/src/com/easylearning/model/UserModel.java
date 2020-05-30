package com.easylearning.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import com.easylearning.entity.User;

public class UserModel {
	
	
	public List<User> listModel(DataSource source)
	{
		Connection con=null;
		String str="";
		int user_id=0;
		String email_id="";
		List<User> users=new ArrayList<>();
		try {
			con=source.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			while(rs.next())
			{
				
				user_id=rs.getInt(1);
				str=rs.getString(2);
				email_id=rs.getString(3);
				User user=new User(user_id,str,email_id);
				users.add(user);
				System.out.println(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}

	public boolean addUser(User user, DataSource source) {
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			 conn=source.getConnection();
			 ps=conn.prepareStatement("insert into user(user_name,emailid) values(?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmailid());
			 status=ps.execute();
			if(status){
				System.out.println("successfully inserted");
			return true;	
			}
			else{
			System.out.println("failed");
			return false;
			}
		} catch (SQLException e) {
			return false;
		}
		finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	

	public void updateUser(String userid, String uname2, String email2,DataSource source) {
		
		
	try {
		Connection conn=	source.getConnection();
		//UPDATE studyeasy_db.user set user_name='lake2' , emailid='lake2@gmail.com' where user_id=9;
		PreparedStatement ps=conn.prepareStatement("update user set user_name=? , emailid=? where user_id=?");
		ps.setString(1, uname2);
		ps.setString(2, email2);
		ps.setInt(3, Integer.parseInt(userid));
		
		ps.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

	public void deleteUser(String userId, DataSource source) {
		try {
		Connection conn=	source.getConnection();
		//UPDATE studyeasy_db.user set user_name='lake2' , emailid='lake2@gmail.com' where user_id=9;
		PreparedStatement ps=conn.prepareStatement("delete from user where user_id=?");
		
			ps.setInt(1,Integer.parseInt(userId));
			ps.execute();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
