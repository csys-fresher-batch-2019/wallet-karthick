package citiipay.login;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;
import citiipay.messages.DBException;

public class TestLogin {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNumber = sc.nextLong();
		System.out.println("Enter the Pin Number");
		int pinNumber = sc.nextInt();
		LogindaoImpl obj=new LogindaoImpl();
		String result=obj.login(mobileNumber, pinNumber);
		System.out.println(result);
	}

}
