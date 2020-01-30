package citipe;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	public static Connection connect() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//String server  ="localhost";
		String server = "CSLH2028";
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@"+ server +":1521:XE", "system", "oracle");
		//System.out.println(connection);
		return connection;
	}
}
