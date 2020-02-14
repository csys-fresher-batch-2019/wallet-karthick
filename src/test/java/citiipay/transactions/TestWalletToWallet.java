package citiipay.transactions;

import java.util.Scanner;

import citiipay.implementation.LogindaoImpl;
import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;

public class TestWalletToWallet {

	public static void main(String[] args) throws DBException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Sender Mobile Number:");
		long mobileNumber1 = sc.nextLong();
		System.out.println("Enter the Receiver Mobile Number:");
		long mobileNumber2 = sc.nextLong();
		if(mobileNumber1!=mobileNumber2) {
			LogindaoImpl obj=new LogindaoImpl();
			int results=obj.mobPersonalVerification(mobileNumber2);
			if(results==0) {
				System.out.println("Enter the Transfer Amount");
				int amount=sc.nextInt();
				System.out.println("Enter any comments:");
				String comments = sc.next();
				TransactiondaoImpl obj1=new TransactiondaoImpl();
				String result=obj1.walletTransaction(mobileNumber1, mobileNumber2,amount,comments);
				System.out.println(result);
			}
			else {
				System.out.println("Receiver Account doesnot exists");
			}
		}
		else {
			System.out.println("Sender and Receiver cannot be the same person");
		}
		
	}

}
