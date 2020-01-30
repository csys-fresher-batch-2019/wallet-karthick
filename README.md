# wallet-karthick

#### Dependency
```
<dependency>
			<groupId>com.karthi</groupId>
			<artifactId>citipe</artifactId>
			<version>1.0.0</version>
		</dependency>
```
#### Create a Class
```
public class WalletAPI {
	private static final Long COMPANY_MOBILE_NO = 6789012340L; //use your registered wallet mobileno
	public static boolean pay(Long mobileNo , int pin, int amount) {
		UserService userService = new UserService();
		boolean status ;
		try {
			status = userService.walletTransfer(mobileNo, COMPANY_MOBILE_NO, pin, amount);
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
        return status;
	}
}
```

