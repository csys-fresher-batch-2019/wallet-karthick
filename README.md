# wallet-karthick

#### Dependency
```
<dependency>
			<groupId>com.karthi</groupId>
			<artifactId>citipe</artifactId>
			<version>0.0.1-snapshot</version>
		</dependency>
```

#### Add Client

```
import citipe.servicelayer.UserService;

public class TestWallet {

	public static void main(String[] args) {

		UserService userService = new UserService();
		long mobileNumber = 9999999999L;
		long originator = 6789012340L;
		int pinNumber = 1234;
		float amount = 1000;
		try {
			boolean status = userService.walletTransaction(mobileNumber, originator, pinNumber, amount);
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}```
