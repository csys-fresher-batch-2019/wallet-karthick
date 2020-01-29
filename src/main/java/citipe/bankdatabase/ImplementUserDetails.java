package citipe.bankdatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import citipe.Connect;
import citipe.DAO.*;

public class ImplementUserDetails implements UserDetailsDAO{


	public void databaseEntry(UserDetails user) throws Exception {
		
		Connection conn = Connect.connect();
		String sql= "insert into account_details(user_name,mobile_no,email_id,account_no,balance,account_status)values (?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1,user.getUserName());
		pst.setLong(2, user.getMobileNumber());
		pst.setString(3,user.getEmailId());
		pst.setLong(4, user.getAccountNumber());
		pst.setFloat(5,user.getBalance());
		pst.setString(6,user.getAccountStatus());
		//pst.setString(7,user.kycDetails);
		int rows=pst.executeUpdate();
		conn.close();
		System.out.println(rows);
	}


	public ArrayList<UserDetails> activeUsers(String status) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		String sql="select user_name,mobile_no,account_no from account_details where account_status=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1,status);
		ResultSet rs=stmt.executeQuery();
		ArrayList<UserDetails> list=new ArrayList<UserDetails>();
 		while(rs.next()) {
 			UserDetails user=new UserDetails();

			user.setUserName(rs.getString("user_name"));
			user.setMobileNumber(rs.getLong("mobile_no"));
			user.setAccountNumber(rs.getLong("account_no"));
			
	 		list.add(user);
		}conn.close();
		return list;
	}
	
}
