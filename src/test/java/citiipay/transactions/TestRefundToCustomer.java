package citiipay.transactions;

import java.util.Scanner;

import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;

public class TestRefundToCustomer {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Merchant Id:");
		String merchantId = sc.next();
		System.out.println("Enter the Transaction Id:");
		int transactionId = sc.nextInt();
		System.out.println("Enter the Transfer Amount");
		int amount=sc.nextInt();
		TransactiondaoImpl obj1=new TransactiondaoImpl();
		String result=obj1.refundToCustomer(merchantId, transactionId, amount);
		System.out.println(result);
	}

}
