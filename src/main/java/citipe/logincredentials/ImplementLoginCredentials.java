package citipe.logincredentials;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import citipe.Connect;
import citipe.DAO.LoginCredentialsDAO;

public class ImplementLoginCredentials implements  LoginCredentialsDAO{

	public String login(long mobileNumber,int pinNumber) throws Exception{
		// TODO Auto-generated method stub
			Connection conn = Connect.connect();

			CallableStatement cStmt = conn.prepareCall("{call login_procedure(?,?,?)}");
			
		    cStmt.setLong(1,mobileNumber);
		    cStmt.setInt(2,pinNumber);
		    cStmt.registerOutParameter(3, Types.VARCHAR);
		    cStmt.executeUpdate();
		    String result = cStmt.getString(3);
		    conn.close();
		    //System.out.println(result);
		return result;
	}
	
	/*public String login1(UserLogin user ) throws Exception {
		Connection conn = TestDatabase.connect();

		CallableStatement cStmt = conn.prepareCall("{call login_procedure(?,?,?)}");
	   
	    cStmt.setLong(1,user.getMobileNumber());
	    cStmt.setInt(2,user.getPinNumber());
	    cStmt.registerOutParameter(3, Types.VARCHAR);
	    cStmt.executeUpdate();
	    String result = cStmt.getString(3);
	    conn.close();
	    if(result.equals("Account logged-in") || result.equals("Account created")) {
	    	
	    }
	    else {
	    	throw new Exception(result);
	    }
		return result;
		
	}*/

	public String pinUpdate(long mobileNumber,int pinNumber) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = Connect.connect();
		String sql = "update login set upi_passwd=? where mobile_no=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,pinNumber);
		stmt.setLong(2, mobileNumber);
		int rows=stmt.executeUpdate();
		conn.close();
		if(rows==0) {
			String result="Pin number not updated";
			return result;
		}
		else {
			String result="Pin number updated";
			return result;
		}
		
	}

	public String forgetPassword(long mobileNumber, String userName, long accountNumber) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		String sql="select user_name,account_no from account_details where mobile_no=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setLong(1,mobileNumber);
		ResultSet rs=stmt.executeQuery();
		String result="";
		while(rs.next()) {
		String username=rs.getString("user_name");
		long accountnumber=rs.getLong("account_no");
		if(username.equals(userName) && accountnumber==accountNumber) {
			result="Verification Successful";
		}
		else {
			result="Verification Failed";
		}
	}conn.close();
		return result;
	}

	public int mobVerification(long mobileNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		CallableStatement Stmt = conn.prepareCall("{call mob_chk_proc(?,?)}");
	    Stmt.setLong(1,mobileNumber);
	    Stmt.registerOutParameter(2, Types.INTEGER);
	    Stmt.executeUpdate();
	    int result=Stmt.getInt(2);
	    conn.close();
		return result;
	}
	
	
	public  boolean validate(UserLogin user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();

		CallableStatement cStmt = conn.prepareCall("{call login_procedure(?,?,?)}");
	   
	    cStmt.setLong(1,user.getMobileNumber());
	    cStmt.setInt(2,user.getPinNumber());
	    cStmt.registerOutParameter(3, Types.VARCHAR);
	    cStmt.executeUpdate();
	    String result = cStmt.getString(3);
	    boolean results=false;
	    conn.close();
	    if(result.equals("Account logged-in")) {
	    	results=true;
	    }
	    else {
	    	results=false;
	    }
		return results;
	}
	
	

}
