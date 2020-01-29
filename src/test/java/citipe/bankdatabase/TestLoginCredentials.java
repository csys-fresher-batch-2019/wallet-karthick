package citipe.bankdatabase;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import citipe.DAO.DAOFactory;
import citipe.DAO.LoginCredentialsDAO;
import citipe.DAO.TransactionDAO;
import citipe.kycdetails.ImplementKYCDetails;
import citipe.logincredentials.ImplementLoginCredentials;
import citipe.transactiondetails.TransactionDetails;

public class TestLoginCredentials {

	public static void main(String[] args) throws Exception {

		loginCheck();

	}

	public static void loginCheck() throws Exception {
		LoginCredentialsDAO obj1 = new ImplementLoginCredentials();
		Scanner sc = new Scanner(System.in);
		System.out.println("CITIPAY");
		System.out.println("Type 1 for Login \n     2 for Create a New Account \n     3 for Forgot Password");
		int option = sc.nextInt();
		if (option == 1) {
			System.out.println("Enter the Mobile Number:");
			long mobileNumber = sc.nextLong();
			System.out.println("Enter the Pin Number");
			int pinNumber = sc.nextInt();
			String loginResult = obj1.login(mobileNumber, pinNumber);
			System.out.println(loginResult);
			String result1 = "Account logged-in";
			//ImplementTransactionDetails obj = new ImplementTransactionDetails();
			TransactionDAO obj=DAOFactory.toDoTransaction();
			ImplementKYCDetails kyc = new ImplementKYCDetails();
			if (loginResult.equals(result1)) {
				while (true) {
					System.out.println("Type 1 for Bank Balance enquiry");
					System.out.println("Type 2 for Making Transaction");
					System.out.println("Type 3 for Transaction history");
					System.out.println("Type 4 for Updating pin");
					System.out.println("Type 5 for Updating kyc details");
					System.out.println("Type 6 for Wallet Balance Enquiry");
					int option1 = sc.nextInt();
					String flag = "Y";
					int pinNo = 0;
					switch (option1) {
					case 1: {
						System.out.println("Balance Enquiry");
						System.out.println("Enter the pin");
						pinNo = sc.nextInt();
						String balanceEnquiry = obj.balanceCheck(mobileNumber, pinNo);
						System.out.println(balanceEnquiry);
						break;
					}
					case 2: {
						System.out.println("Transaction Details");
						long senderMobileNo = mobileNumber;
						System.out.println("Type 1 to Send money from Account");
						System.out.println("Type 2 to Send money from Wallet");
						int option2=sc.nextInt();
						if(option2==1) {
							System.out.println("Enter the Receiver's mobile number");
							long receiverMobileNo = sc.nextLong();
							if (senderMobileNo != receiverMobileNo) {
								System.out.println("Enter the transfer amount");
								float transferAmount = sc.nextFloat();
								System.out.println("Enter the pin");
								pinNo = sc.nextInt();
								int pinCheck = obj.pinCheck(mobileNumber, pinNo);
								if (pinCheck == 1) {
									String transactionEnquiry = obj.toDoTransaction(senderMobileNo, receiverMobileNo,
											transferAmount, pinNumber);
									System.out.println(transactionEnquiry);
									String result = "Transaction Successfull";
									if (transactionEnquiry.equals(result)) {
										ImplementKYCDetails cashbackObj = new ImplementKYCDetails();
										String result2 = "";
										if (transferAmount > 100 && transferAmount <= 1000) {
											Random r = new Random();
											int low = 10;
											int high = 50;
											int wallet = r.nextInt(high - low) + low;
											result2 = cashbackObj.addingCashback(mobileNumber, wallet);
											System.out.println(result2);
										} else if (transferAmount > 1000 && transferAmount <= 5000) {
											Random r = new Random();
											int low = 50;
											int high = 250;
											int wallet = r.nextInt(high - low) + low;
											result2 = cashbackObj.addingCashback(mobileNumber, wallet);
											System.out.println(result2);
										} else if (transferAmount > 5000) {
											Random r = new Random();
											int low = 250;
											int high = 500;
											int wallet = r.nextInt(high - low) + low;
											result2 = cashbackObj.addingCashback(mobileNumber, wallet);
											System.out.println(result2);
										} else {
											System.out.println("Transfer above Rs.100 to get cash back");
										}
									}
								} else {
									System.out.println("Invalid pin");
								}
							} else {
								System.out.println("Sender and Receiver account are same. So transactions cannot be done");
							}

						}
						else if(option2==2)
						{
							System.out.println("Enter the Receiver's mobile number");
							long receiverMobileNo = sc.nextLong();
							if (senderMobileNo != receiverMobileNo) {
								System.out.println("Enter the transfer amount");
								float transferAmount = sc.nextFloat();
								String transactionEnquiry = obj.walletTransaction(senderMobileNo, receiverMobileNo, transferAmount);
								System.out.println(transactionEnquiry);
								
							}
							else {
								System.out.println("Sender and Receiver account are same. So transactions cannot be done");
							}
						}
						
						else {
							System.out.println("Enter a valid number");
						}
						break;
					}

					case 3: {
						System.out.println("Transaction History");
						System.out.println("Enter 1 to view Money Received");
						System.out.println("Enter 2 to view Money Sent");
						System.out.println("Enter 3 to view Failed transactions");
						int transactionCategoryOption = sc.nextInt();
						ArrayList<TransactionDetails> list = new ArrayList<TransactionDetails>();
						String category = "";
						if (transactionCategoryOption >= 1 && transactionCategoryOption <= 3) {
							if (transactionCategoryOption == 1) {
								category = "Debited";
							} else if (transactionCategoryOption == 2) {
								category = "Credited";
							} else {
								category = "Failed";
							}
							list = obj.transactionHistoryByCategory(mobileNumber, category);
							for (TransactionDetails transactionDetails : list) {
								System.out.println(transactionDetails);
							}
						} else {
							System.out.println("Please enter a valid number");
						}
						break;
					}
					case 4: {
						System.out.println("Pin updation");
						System.out.println("Enter the pin");
						pinNo = sc.nextInt();
						int pinCheck = obj.pinCheck(mobileNumber, pinNo);
						if (pinCheck == 1) {
							System.out.println("Create new Pin");
							int pinNumber1 = sc.nextInt();
							System.out.println("Re-Enter the Pin");
							int pinNumber2 = sc.nextInt();
							if (pinNumber1 == pinNumber2) {
								String pinUpdationResult = obj.pinUpdate(mobileNumber, pinNumber1);
								System.out.println(pinUpdationResult);
							} else {
								System.out.println("Re-Entered pin is wrong");
							}
						} else {
							System.out.println("Invalid pin");
						}
						break;
					}

					case 5: {

						System.out.println("KYC Details Updation");
						System.out.println("Type 1 for Updating Aadhar Details");
						System.out.println("Type 2 for Upadting Passport Details");
						System.out.println("Type 3 for Updating Driving License Details");
						int kycOption = sc.nextInt();
						if (kycOption >= 1 && kycOption <= 3) {
							System.out.println("Enter the Username");
							String userName = sc.next();
							if (kycOption == 1) {
								System.out.println("Enter the Aadhar Number");
								String aadharNumber = sc.next();
								String result = kyc.addingKyc(mobileNumber, aadharNumber, null, null, userName);
								System.out.println(result);
							} else if (kycOption == 2) {
								System.out.println("Enter the Passport Number");
								String passportNumber = sc.next();
								String result = kyc.addingKyc(mobileNumber, null, passportNumber, null, userName);
								System.out.println(result);
							} else {
								System.out.println("Enter the Driving License Number");
								String drivingLicenseNo = sc.next();
								String result = kyc.addingKyc(mobileNumber, null, null, drivingLicenseNo, userName);
								System.out.println(result);
							}
						}
						break;
					}

					case 6: {
						System.out.println("Wallet Balance");
						int walletBalance = kyc.walletBalanceCheck(mobileNumber);
						System.out.println(walletBalance);
					}
					}

					System.out.println("To continue performing operations type Y else N");
					flag = sc.next();
					if (flag.equals("N")) {
						System.out.println("Thank you");
						System.exit(0);
					}
				}
			}

		} else if (option == 2) {
			System.out.println("Enter the Mobile Number:");
			long mobileNumber = sc.nextLong();
			ImplementLoginCredentials obj=new ImplementLoginCredentials();
			int verify=obj.mobVerification(mobileNumber);
			if(verify==1) {
				System.out.println("Create new Pin");
				int pinNumber1 = sc.nextInt();
				System.out.println("Re-Enter the Pin");
				int pinNumber2 = sc.nextInt();
				if (pinNumber1 == pinNumber2) {
					String loginResult = obj1.login(mobileNumber, pinNumber1);
					System.out.println(loginResult);
				} else {
					System.out.println("Re-Entered pin is wrong");
				}
			}
			else {
				System.out.println("Account already exists");
			}
			
		}

		else if (option == 3) {
			System.out.println("Enter the Mobile Number:");
			long mobileNumber = sc.nextLong();
			System.out.println("Enter the User name");
			String userName = sc.next();
			System.out.println("Enter the Account Number:");
			long accountNumber = sc.nextLong();
			String forgetpass = obj1.forgetPassword(mobileNumber, userName, accountNumber);
			System.out.println(forgetpass);
			if (forgetpass == "Verification Successful") {
				System.out.println("Create new Pin");
				int pinNumber1 = sc.nextInt();
				System.out.println("Re-Enter the Pin");
				int pinNumber2 = sc.nextInt();
				if (pinNumber1 == pinNumber2) {
					String loginResult = obj1.pinUpdate(mobileNumber, pinNumber1);
					System.out.println(loginResult);
				} else {
					System.out.println("Re-Entered pin is wrong");
				}
			}

		}

		else {
			System.out.println("Entry invalid.Please enter a valid number - 1 or 2 or 3");
		}
	}

}
