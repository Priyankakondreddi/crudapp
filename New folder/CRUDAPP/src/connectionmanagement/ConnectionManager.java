package connectionmanagement;

import java.sql.*;

public class ConnectionManager {
		Connection cn=null;
		public Connection establishConnection() throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudapp","root","Priya@716");
			return cn;
		}
		public void closeConnection() throws SQLException 
		{
			cn.close();
		}
}
