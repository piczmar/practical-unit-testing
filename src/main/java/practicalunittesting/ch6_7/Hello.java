package practicalunittesting.ch6_7;

import java.util.Calendar;

public class Hello {

	private Calendar calendar = Calendar.getInstance();

	public String sayHello() {
		if (calendar.get(Calendar.HOUR_OF_DAY) < 12) {
			return "Hello in the morning";
		} else {
			return "Hello afternoon";
		}
	}
}
