package practicalunittesting.ch6_7;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Calendar;

import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HelloRefactoredTest {

	private static final String HELLO_MORNING = "Hello in the morning";
	private static final String HELLO_AFTERNOON = "Hello afternoon";

	@DataProvider
	private static final Object[][] morningHours() {
		return new Object[][] { { getCalendar(0) }, { getCalendar(1) }, { getCalendar(10) }, { getCalendar(11) }, };

	}

	@Test(dataProvider = "morningHours")
	public void shouldSayHelloInTheMorning(Calendar morningHour) {
		TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
		HelloRefactored hello = new HelloRefactored(timeProvider);

		Mockito.when(timeProvider.getTime()).thenReturn(morningHour);

		assertThat(hello.sayHello()).isEqualTo(HELLO_MORNING);
	}

	@DataProvider
	private static final Object[][] afternoonHours() {
		return new Object[][] { { getCalendar(12) }, { getCalendar(18) }, { getCalendar(22) }, { getCalendar(23) }, };

	}

	@Test(dataProvider = "afternoonHours")
	void shouldSayHelloAfternoon(Calendar afternoonHour) {
		TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
		HelloRefactored hello = new HelloRefactored(timeProvider);

		Mockito.when(timeProvider.getTime()).thenReturn(afternoonHour);

		assertThat(hello.sayHello()).isEqualTo(HELLO_AFTERNOON);
	}

	private static Calendar getCalendar(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		return calendar;
	}
}
