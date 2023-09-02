package dao;

import java.sql.*;

import connectionmanagement.ConnectionManager;
import model.productdetails;

public class productDAO{
	
	public void addproduct(productdetails pd) throws ClassNotFoundException, SQLException {
		String product_name=pd.getProduct_name();
		int product_id=pd.getProduct_id();
		int product_min=pd.getProduct_min();
		int product_price=pd.getProduct_price();
		int product_quantity=pd.getProduct_quantity();
		
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="insert into productdetails(product_name,product_id,product_min,product_price,product_quantity) values(?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(que);
		st.setString(1, product_name);
		st.setInt(2, product_id);
		st.setInt(3, product_min);
		st.setInt(4, product_price);
		st.setInt(5, product_quantity);
		st.executeUpdate();
		cm.closeConnection();
		
		
		
	}
	
	public void display(productdetails pd) throws SQLException, ClassNotFoundException
	{
		//2.jdbc connection
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		//3.where to write queries
		//3.1 create statement class
		Statement st=con.createStatement();
		
		//3.2 Write execute the queries
		ResultSet rt = st.executeQuery("select * from productdetails");
		
		//4. check the credentials
		while(rt.next())
		{
				
			System.out.print(rt.getString("product_name")+"   "+rt.getInt("product_id")+"   "+rt.getInt("product_min")+"   "+rt.getInt("product_price")+"   "+ rt.getInt("product_quantity")+"\n\n");
		}
		cm.closeConnection();	
	}
	
	public void update(productdetails pd) throws SQLException, ClassNotFoundException {
		String product_name=pd.getProduct_name();
		int product_id=pd.getProduct_id();
		int product_min=pd.getProduct_min();
		int product_price=pd.getProduct_price();
		int product_quantity=pd.getProduct_quantity();
		
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="update productdetails set product_name=?,product_min=?,product_price=?,product_quantity=? where product_id=?";
		PreparedStatement st=con.prepareStatement(que);
		st.setString(1, product_name);
		st.setInt(2, product_id);
		st.setInt(3, product_min);
		st.setInt(4, product_price);
		st.setInt(5, product_quantity);
		st.executeUpdate();
		cm.closeConnection();
		
}
	public void delete(productdetails pd) throws ClassNotFoundException, SQLException
	{
		int product_id=pd.getProduct_id();
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();

		String que="delete from productdetails where product_id=?";
		PreparedStatement st=con.prepareStatement(que);
		st.setInt(1,product_id);
		st.executeUpdate();
		cm.closeConnection();
		
		
	}
}
	
	
	
	

