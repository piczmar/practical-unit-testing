package practicalunittesting.ch6_7;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

public class HelloTest {

	private Hello hello = new Hello();
	private static final String HELLO_MORNING = "Hello in the morning";
	private static final String HELLO_AFTERNOON = "Hello afternoon";

	@Test(enabled=false)
	public void shouldSayHelloInTheMorning() {
		assertThat(hello.sayHello()).isEqualTo(HELLO_MORNING);
	}

	@Test(enabled=false)
	void shouldSayHelloAfternoon() {
		assertThat(hello.sayHello()).isEqualTo(HELLO_AFTERNOON);
	}
}
