package practicalunittesting.ch3;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MoneyTest {

	@Test
	public void constructorShouldSetAmountAndCurrency() {
		Money money = new Money(10, "USD");

		assertEquals(money.getAmount(), 10);
		assertEquals(money.getCurrency(), "USD");
	}

}
