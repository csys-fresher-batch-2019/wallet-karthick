# wallet-karthick

#### Download 
* [ wallet-1.0.1.jar ](  https://pkg.githubusercontent.com/236468850/48738480-4356-11ea-8547-c6d54b34d4b7?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20200130%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200130T072831Z&X-Amz-Expires=300&X-Amz-Signature=7a5750df7b3a4ffb83743fe358fba7f94f507675844a46357acea50d6fea9566&X-Amz-SignedHeaders=host&actor_id=59196289&response-content-disposition=filename%3Dcitipe-1.0.1.jar&response-content-type=application%2Foctet-stream )

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

