package practicalunittesting.ch6_7;

import java.util.Calendar;

public class HelloRefactored {

	private TimeProvider timeProvider;

	public HelloRefactored(TimeProvider timeProvider){
		this.timeProvider = timeProvider;
	}
	public String sayHello() {
		if (timeProvider.getTime().get(Calendar.HOUR_OF_DAY) < 12) {
			return "Hello in the morning";
		} else {
			return "Hello afternoon";
		}
	}
}
