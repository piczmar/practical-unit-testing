package practicalunittesting.ch5;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class CarTest {

	@Test
	public void test() {
		Car myFerrari = mock(Car.class);
		assertFalse(myFerrari.needsFuel(), "by default shoud not need fuel");

		when(myFerrari.needsFuel()).thenReturn(true);

		assertTrue(myFerrari.needsFuel(), "modified by Mockito now it should need fuel");

	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void shouldThrowException() {
		Car myFerrari = mock(Car.class);

		when(myFerrari.needsFuel()).thenThrow(new RuntimeException());

		myFerrari.needsFuel(); // here exception will be thrown

	}

	@Test
	public void shouldVerifyMethodCall() {
		Car myFerrari = mock(Car.class);

		myFerrari.driveTo("Sweet home Alabama");
		myFerrari.needsFuel();

		verify(myFerrari).driveTo("Sweet home Alabama");
		verify(myFerrari).needsFuel();

	}
}
