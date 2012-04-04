package practicalunittesting.ch3;

public class ComplexObject {
	private int amount;

	public ComplexObject(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return "USD";
	}
}
