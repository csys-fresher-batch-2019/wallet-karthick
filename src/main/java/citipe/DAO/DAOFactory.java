package citipe.DAO;

import citipe.logincredentials.ImplementLoginCredentials;
import citipe.transactiondetails.ImplementTransactionDetails;

public class DAOFactory {
	
	public static TransactionDAO toDoTransaction() {
		
		TransactionDAO obj=new ImplementTransactionDetails();
		return obj;
		
	}

	public static LoginCredentialsDAO login() {
		
		ImplementLoginCredentials obj = new ImplementLoginCredentials();
		return obj;
		
	}
	
	
	

}
