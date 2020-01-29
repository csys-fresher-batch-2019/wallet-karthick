package citipe.bankdatabase;

import citipe.servicelayer.UserService;

public class TestWalletTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService obj=new UserService();
		try {
			obj.walletTransaction(6789012347L,6789012340L,1000,(float)100);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
