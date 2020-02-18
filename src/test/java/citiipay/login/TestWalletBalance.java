package citiipay.login;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;

public class TestWalletBalance {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNumber = sc.nextLong();
		LogindaoImpl obj=new LogindaoImpl();
		int balance=obj.balanceCheck(mobileNumber);
		System.out.println(balance);
	}

}
