package citipe.DAO;

import citipe.transactiondetails.ImplementTransactionDetails;

public class DAOFactory {
	
	public static TransactionDAO toDoTransaction() {
		
		
		TransactionDAO obj=new ImplementTransactionDetails();
		return obj;
	}

	

}
