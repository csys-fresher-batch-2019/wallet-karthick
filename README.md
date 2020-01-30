# wallet-karthick

#### Download 
* [ wallet-1.0.2.jar ]( https://pkg.githubusercontent.com/236468850/242d9d00-4382-11ea-9271-9a70145417af?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20200130%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200130T113829Z&X-Amz-Expires=300&X-Amz-Signature=0627828aa605b88641416231450d72a6a359495429990489149b98e3c180680f&X-Amz-SignedHeaders=host&actor_id=59196289&response-content-disposition=filename%3Dcitipe-1.0.2.jar&response-content-type=application%2Foctet-stream )

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

