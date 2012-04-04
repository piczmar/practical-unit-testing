package practicalunittesting.ch3;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider
	private static final Object[][] getMoney() {
		return new Object[][] { { 10, "USD" }, { 20, "USD" } };
	}

	@DataProvider
	private static final Iterator<Object[]> getLazyData() {
		return new Iterator<Object[]>() {

			private int counter = 1;

			public boolean hasNext() {
				return counter < 100;
			}

			public Object[] next() {
				return new Object[] { new ComplexObject(counter++) };
			}

			public void remove() {
				// not important now
			}

		};
	}
}
