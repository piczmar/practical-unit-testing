package practicalunittesting.ch4;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class PasswordValidatorTest {

	private static final String PASSWORD_WITHOUT_CAPITAL_LETTER = "a1bc";
	private static final String PASSWORD_WITHOUT_DIGITS = "abcD";
	private static final String PASSWORD_TOO_SHORT = "abcD1";
	private static final String PASSWORD_WITH_6_CHARS = "abcDe1";

	@Test(expectedExceptions = InvalidPasswordException.class)
	public void shouldContainAtLeastOneCapitalLetter() throws InvalidPasswordException {

		PasswordValidator.validate(PASSWORD_WITHOUT_CAPITAL_LETTER);
	}

	@Test
	public void shouldContainAtLeastOneDigitLetter() {
		try {
			PasswordValidator.validate(PASSWORD_WITHOUT_DIGITS);
			fail();
		} catch (InvalidPasswordException e) {
			assertTrue(e.getMessage().contains(PasswordValidator.PASSWORD_SHOULD_CONTAIN_DIGIT));
		}

	}

	@Test
	public void shouldBeAtLeast6CharLong() {
		try {
			PasswordValidator.validate(PASSWORD_TOO_SHORT);
			fail();
		} catch (InvalidPasswordException e) {
			assertTrue(e.getMessage().contains(PasswordValidator.PASSWORD_SHOULD_BE_6_CHAR_LONG));
		}

	}

	@Test
	public void shouldAllowPasswordWith6Chars() throws InvalidPasswordException {
		PasswordValidator.validate(PASSWORD_WITH_6_CHARS);
	}
}
