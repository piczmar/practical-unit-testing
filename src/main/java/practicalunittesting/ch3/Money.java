package practicalunittesting.ch3;

public class Money {
	private final int amount;
	private final String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Money) {
			Money money = (Money) obj;
			return money.getAmount() == amount && money.getCurrency() == currency;
		}
		return false;
	}
}
