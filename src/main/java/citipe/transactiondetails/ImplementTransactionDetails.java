package citipe.transactiondetails;

import java.sql.CallableStatement;
//import citipe.logincredentials.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import citipe.Connect;
import citipe.DAO.TransactionDAO;

public class ImplementTransactionDetails implements TransactionDAO {


	public String balanceCheck(long mobileNumber, int pinNumber) throws Exception {
		
		Connection conn = Connect.connect();
		ImplementTransactionDetails obj=new ImplementTransactionDetails();
		int pin=obj.pinCheck(mobileNumber,pinNumber);
		String result="";
		//System.out.println(pin);
		if(pin==1) {
			String balanceSql="select balance from account_details where mobile_no=?";
			PreparedStatement stmt2=conn.prepareStatement(balanceSql);
			stmt2.setLong(1,mobileNumber);
			ResultSet rs2=stmt2.executeQuery();
			while(rs2.next()) {
				float balance=(float) 0;
				balance=rs2.getFloat("balance");
				result=String.valueOf(balance);
				}	
			}
		else {
			result="Invalid pin";
		}conn.close();
		return result;
	}
	
	public String toDoTransaction(long senderMobileNo, long receiverMobileNo, float transferAmount, int pinNumber) throws Exception {

		Connection conn = Connect.connect();
		CallableStatement cStmt = conn.prepareCall("{call transaction_proc(?,?,?,?,?)}");
		cStmt.setLong(1,senderMobileNo);
		cStmt.setLong(2,receiverMobileNo);
		cStmt.setFloat(3,transferAmount);
		cStmt.setInt(4,pinNumber);
		cStmt.registerOutParameter(5, Types.VARCHAR);
		cStmt.executeUpdate();
		String result = cStmt.getString(5);
		conn.close();
		return result;
	}

	public ArrayList<TransactionDetails> transactionHistoryByCategory(long mobileNumber, String category) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		String transactionHistory="select * from transaction_table where categories=? ";
		PreparedStatement stmt=conn.prepareStatement(transactionHistory);
		stmt.setString(1, category);
		ResultSet rs=stmt.executeQuery();
		ArrayList<TransactionDetails> list=new ArrayList<TransactionDetails>();
		while(rs.next()) {
 			TransactionDetails user=new TransactionDetails();
			user.setSenderNumber(rs.getLong("mobile_no"));
			user.setReceiverNumber(rs.getLong("mobile_no"));
			user.setCategory(rs.getString("categories"));
			user.setTransactionDate(rs.getTimestamp("transaction_time"));
			user.setTransactionAmount(rs.getFloat("transaction_amount"));
			user.setTransactionStatus(rs.getString("transaction_status"));
	 		list.add(user);
		}conn.close();
		return list;
	}

	public int pinCheck(long mobileNumber,int pinNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		String passwordSql="select upi_passwd from login where mobile_no=?";
		PreparedStatement stmt=conn.prepareStatement(passwordSql);
		stmt.setLong(1,mobileNumber);
		ResultSet rs1=stmt.executeQuery();
		int pin=0,flag=0;
		while(rs1.next()) {
			pin=rs1.getInt("upi_passwd");
		}conn.close();
		if(pin==pinNumber) {
			flag=1;
			}
		else {
			flag=0;
		}
		return flag;
	}
	
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

	public String walletTransaction(long senderMobileNo, long receiverMobileNo, float transferAmount) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		CallableStatement cStmt = conn.prepareCall("{call wallet_proc(?,?,?,?)}");
		cStmt.setLong(1,senderMobileNo);
		cStmt.setLong(2,receiverMobileNo);
		cStmt.setFloat(3,transferAmount);
		cStmt.registerOutParameter(4, Types.VARCHAR);
		cStmt.executeUpdate();
		String result = cStmt.getString(4);
		conn.close();
		return result;
		
	}
	
	
	



}
