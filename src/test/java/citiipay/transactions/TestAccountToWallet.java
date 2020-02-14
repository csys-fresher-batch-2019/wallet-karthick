package citiipay.transactions;

import java.util.Scanner;

import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;
import citiipay.models.CashBack;

public class TestAccountToWallet {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number:");
		long accountNo = sc.nextLong();
		System.out.println("Enter the Receiver Mobile Number:");
		long mobileNo = sc.nextLong();
		System.out.println("Enter the Transfer Amount");
		int amount=sc.nextInt();
		System.out.println("Enter any comments:");
		String comments = sc.next();
		TransactiondaoImpl obj1=new TransactiondaoImpl();
		CashBack object=new CashBack();
		object=obj1.accountToWallet(mobileNo, accountNo, amount, comments);
		System.out.println(object.getResult());
		System.out.println("Cashback of "+object.getCashbackAmount()+" is added");
			
	}

}
