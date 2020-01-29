package citipe.bankdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import citipe.bankdatabase.UserDetails;

public class TestDatabase {

	public static void main(String[] args) throws Exception{
		
		entryToDatabase();
		
		//activeUser();
		
		
	}

	public static void activeUser() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Account Status:");
		String status=sc.next();
		ArrayList<UserDetails> list=new ArrayList<UserDetails>();
		ImplementUserDetails obj = new ImplementUserDetails();
		list=obj.activeUsers(status);
		for (UserDetails userDetails : list) {
			System.out.println(userDetails);
		}
	}
	
	public static Connection connect() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//String server  ="localhost";
		String server = "CSLH2018";
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@"+ server +":1521:XE", "system", "oracle");
		//System.out.println(connection);
		return connection;
	}

	public static void entryToDatabase() throws Exception {
		ImplementUserDetails obj = new ImplementUserDetails();
		Scanner sc=new Scanner(System.in);
		UserDetails user=new UserDetails();
		System.out.println("userName");
		user.setUserName(sc.next());
		System.out.println("mobileNumber");
		user.setMobileNumber(sc.nextLong());
		System.out.println("emailId");
		user.setEmailId(sc.next());
		System.out.println("accountNumber");
		user.setAccountNumber(sc.nextLong());
		System.out.println("balance");
		user.setBalance(sc.nextFloat());
		System.out.println("accountStatus");
		user.setAccountStatus(sc.next());
		//System.out.println("kycDetails");
		//user.kycDetails=sc.next();
		obj.databaseEntry(user);
	}


}
