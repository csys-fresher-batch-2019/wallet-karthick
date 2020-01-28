package citipe.DAO;

import java.util.ArrayList;

import citipe.bankdatabase.UserDetails;

public interface UserDetailsDAO {
	
	public void databaseEntry(UserDetails user) throws Exception;
	
	public ArrayList<UserDetails> activeUsers(String status) throws Exception ;
}
