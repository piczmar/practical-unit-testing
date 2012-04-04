package practicalunittesting.ch3;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
public class MoneyTest {

	/**
	 * This test is invoked with dynamic data provider which will create
	 * helperObject at runtime to not consume too many memory resources
	 */
	@Test(dataProviderClass = DataProviders.class, dataProvider = "getLazyData", skipFailedInvocations = true)
	public void constructorShouldSetAmountAndCurrency(ComplexObject helperObject) {
		Money money = new Money(helperObject.getAmount(), helperObject.getCurrency());

		assertEquals(money.getAmount(), helperObject.getAmount());
		assertEquals(money.getCurrency(), helperObject.getCurrency());
	}

}
