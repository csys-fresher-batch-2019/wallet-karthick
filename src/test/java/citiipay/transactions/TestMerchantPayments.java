package citiipay.transactions;

import java.util.ArrayList;
import java.util.Scanner;

import citiipay.implementation.TransactiondaoImpl;
import citiipay.messages.DBException;
import citiipay.models.MerchantTableDetails;

public class TestMerchantPayments {

	public static void main(String[] args) throws DBException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		long mobileNo = sc.nextLong();
		TransactiondaoImpl obj=new TransactiondaoImpl();
		ArrayList<MerchantTableDetails> list = new ArrayList<>();
		list=obj.transactionMerchant(mobileNo);
		for (MerchantTableDetails merchantTableDetails : list) {
			System.out.println(merchantTableDetails);
		}
		
		
	}

}
