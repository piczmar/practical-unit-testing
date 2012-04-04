package practicalunittesting.ch3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoneyIAETest {

	private static final String VALID_CURRENCY = "USD";
	private static final int VALID_AMOUNT = 5;

	@DataProvider
	private static final Object[][] getInvalidAmount() {
		return new Integer[][] { { -1 }, { -10 } };
	};

	@Test(dataProvider = "getInvalidAmount", expectedExceptions = { IllegalArgumentException.class })
	public void constructorShouldThrowIAEWhenInvalidAmount(int amount) {
		Money money = new Money(amount, VALID_CURRENCY);
	}

	@DataProvider
	private static final Object[][] getInvalidCurrency() {
		return new String[][] { { null }, { "" } };
	}

	@Test(dataProvider = "getInvalidAmount", expectedExceptions = { IllegalArgumentException.class })
	public void constructorShouldThrowIAEWhenInvalidCurrency(String currency) {
		Money money = new Money(VALID_AMOUNT, currency);
	}
}
