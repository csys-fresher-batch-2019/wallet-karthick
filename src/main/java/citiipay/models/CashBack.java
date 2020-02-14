package citiipay.models;

public class CashBack {

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCashbackAmount() {
		return cashbackAmount;
	}

	public void setCashbackAmount(int cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}

	private int cashbackAmount;

}
