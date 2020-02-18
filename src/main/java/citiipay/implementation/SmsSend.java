package citiipay.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class SmsSend {

	public static void msgPersonal(long mobileNo) {
		String authkey = "318151As596OCYE5e45440cP1";
		String mobiles = Long.toString(mobileNo);
		String senderId = "WALLET";
		String country = "91";
		String route = "4";
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + "You have successfully registered your CitiWallet account using " + mobiles);
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void msgBussiness(long mobileNo) {
		String authkey = "318151As596OCYE5e45440cP1";
		String mobiles = Long.toString(mobileNo);
		String senderId = "WALLET";
		String country = "91";
		String route = "4";
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append(
				"&message=" + "You have successfully registered your CitiWallet Bussiness account using " + mobiles);
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int msgForegetPassword(long mobileNo) {
		String authkey = "318151As596OCYE5e45440cP1";
		String mobiles = Long.toString(mobileNo);
		String senderId = "WALLET";
		String country = "91";
		Random rand = new Random();
		int message = rand.nextInt(99999);
		String route = "4";
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + message + " is your CitiWallet OTP.OTP is confidential");
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return message;
	}

	public static void msgSender(long senderMobileNo, long receiverMobileNo, float amount) {
		String authkey = "318151As596OCYE5e45440cP1";
		String mobiles = Long.toString(senderMobileNo);
		String mobiles1 = Long.toString(receiverMobileNo);
		String senderId = "WALLET";
		String country = "91";
		String route = "4";
		String amounts = Float.toString(amount);
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + "Your AC" + mobiles + " Debited INR " + amounts + " on " + formattedDate
				+ " to " + mobiles1);
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void msgReceiver(long senderMobileNo, long receiverMobileNo, float amount) {
		String authkey = "318151As596OCYE5e45440cP1";
		String mobiles = Long.toString(receiverMobileNo);
		String mobiles1 = Long.toString(senderMobileNo);
		String senderId = "WALLET";
		String country = "91";
		String route = "4";
		String amounts = Float.toString(amount);
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + "Your AC" + mobiles + " has a credit by Transfer of Rs " + amounts + " on "
				+ formattedDate + " to " + mobiles1);
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void msgMerchantPay(String merchantId, long receiverMobileNo, float amount) {
		String authkey = "318151As596OCYE5e45440cP1";
		String mobiles = Long.toString(receiverMobileNo);
		String mobiles1 = merchantId;
		String senderId = "WALLET";
		String country = "91";
		String route = "4";
		String amounts = Float.toString(amount);
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + "Thank you for using CitiWallet for Rs." + amounts + " at " + mobiles1 + " on "
				+ formattedDate);
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
