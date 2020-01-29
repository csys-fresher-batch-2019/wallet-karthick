 package citipe.kycdetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import citipe.Connect;
import citipe.DAO.kycDetailsDAO;

public class ImplementKYCDetails implements kycDetailsDAO {

	public int walletBalanceCheck(long mobileNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		String existingWalletSql="select kyc_wallet from kyc where mobile_no=?";
		PreparedStatement stmt1=conn.prepareStatement(existingWalletSql);
		stmt1.setLong(1, mobileNumber);
		ResultSet rs=stmt1.executeQuery();
		int existingWalletAmount=0;
		while(rs.next()) {
			existingWalletAmount=rs.getInt("kyc_wallet");
			}
		conn.close();
		return existingWalletAmount;
	}

	public String addingKyc(long mobileNumber, String aadharNumber, String passportNumber, String drivingLicenseNo,
			String userName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		CallableStatement cStmt = conn.prepareCall("{call kyc_proc(?,?,?,?,?,?)}");
	    cStmt.setLong(1,mobileNumber);
	    cStmt.setString(2,aadharNumber);
	    cStmt.setString(3,passportNumber);
	    cStmt.setString(4,drivingLicenseNo);
	    cStmt.setString(5,userName);
	    cStmt.registerOutParameter(6, Types.VARCHAR);
	    cStmt.executeUpdate();
	    String result = cStmt.getString(6);
	    conn.close();
	    //System.out.println(result);
	return result;
	}

	public String addingCashback(long mobileNumber, int cashback) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Connect.connect();
		CallableStatement Stmt = conn.prepareCall("{call Kyc_Status_Chk_Proc(?,?)}");
	    Stmt.setLong(1,mobileNumber);
	    Stmt.registerOutParameter(2, Types.INTEGER);	
	    Stmt.executeUpdate();
	    int kycStatus = Stmt.getInt(2);
	    String result="";
	    if(kycStatus==1) {
			ImplementKYCDetails obj=new ImplementKYCDetails();
			int existingWalletAmount=obj.walletBalanceCheck(mobileNumber);
			String cashbackSql= "update kyc set kyc_wallet=? where mobile_no=?";
			PreparedStatement stmt2=conn.prepareStatement(cashbackSql);
			int newCashback=existingWalletAmount+cashback;
			stmt2.setInt(1,newCashback);
			stmt2.setLong(2, mobileNumber);
			stmt2.executeUpdate();
			//System.out.println(newCashback);
			result="Cashback of "+cashback +" is added to your wallet";
	    }
	    else {
	    	result="Add KYC Details to get cashback";
	    }
	    conn.close();
		return result;
	}

	
}
