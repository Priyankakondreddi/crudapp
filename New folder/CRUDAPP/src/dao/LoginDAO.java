package dao;

import java.sql.*;

import connectionmanagement.ConnectionManager;
import model.login;

public class LoginDAO {
	
		public boolean CheckCredentials(login l) throws ClassNotFoundException, SQLException {
			//1.get the details from login.java file
			String username= l.getUsername();
			String password= l.getPassword();
			
			//2.jdbc connection
			ConnectionManager cm=new ConnectionManager();
			Connection con=cm.establishConnection();
			
			//3.where to write queries
			//3.1 create statement class
			Statement st=con.createStatement();
			
			//3.2 Write execute the queries
			ResultSet rt = st.executeQuery("select * from login");
			
			//4. check the credentials
			while(rt.next())
			{
				if(username.equals(rt.getString("Username")) && password.equals(rt.getString("Password")))
				{
					cm.closeConnection();
					return true;
				}
			}
			cm.closeConnection();
			return false;	
		}
}
