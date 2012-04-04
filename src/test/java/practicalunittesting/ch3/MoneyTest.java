package practicalunittesting.ch3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MoneyTest {

	@DataProvider
	private static final Object[][] getMoney() {
		return new Object[][] { { 10, "USD" }, { 20, "USD" } };
	}

	@Test(dataProvider = "getMoney")
	public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount, currency);

		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}

}
