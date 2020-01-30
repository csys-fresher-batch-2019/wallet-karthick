package citipe.bankdatabase;

import citipe.servicelayer.UserService;

public class TestWalletTransaction {

	public static void main(String[] args) {
		UserService obj=new UserService();
		try {
			boolean result=obj.walletTransfer(9999999999L,6789012340L,1234,(float)1000);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
