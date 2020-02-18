package citiipay.login;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;
import citiipay.messages.DBException;

public class TestChangePin {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNumber = sc.nextLong();
		System.out.println("Enter the Pin Number");
		int pinNumber1 = sc.nextInt();
		System.out.println("Re-Enter the Pin Number");
		int pinNumber2 = sc.nextInt();
		LogindaoImpl obj=new LogindaoImpl();
		if(pinNumber1==pinNumber2) {
			String result=obj.pinUpdate(mobileNumber, pinNumber1);
			System.out.println(result);
		}
		else {
			System.out.println("Re-entered pin wrong");
			System.out.println("Account not created");				
		}
	}

}
