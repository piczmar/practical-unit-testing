package practicalunittesting.ch3;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MoneyTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "getMoney")
	public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount, currency);

		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}

}
