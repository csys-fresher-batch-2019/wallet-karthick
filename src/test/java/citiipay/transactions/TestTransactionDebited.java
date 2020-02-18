package citiipay.transactions;

import java.util.ArrayList;
import java.util.Scanner;

import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;
import citiipay.models.TransactionDetails;

public class TestTransactionDebited {

	public static void main(String[] args) throws DBException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNo = sc.nextLong();
		TransactiondaoImpl obj=new TransactiondaoImpl();
		ArrayList<TransactionDetails> list = new ArrayList<>();
		list=obj.transactionDebited(mobileNo);
		for (TransactionDetails transactionDetails : list) {
			System.out.println(transactionDetails);
		}
	}

}
