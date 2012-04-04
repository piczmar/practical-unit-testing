package practicalunittesting.ch4;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.*;

public class PasswordValidatorTest {

	private static final String PASSWORD_WITHOUT_CAPITAL_LETTER = "a1bc";
	private static final String PASSWORD_WITHOUT_DIGITS = "abcD";
	private static final String PASSWORD_TOO_SHORT = "abcD1";
	private static final String PASSWORD_WITH_6_CHARS = "abcDe1";
	private static final PasswordValidator PASSWORD_VALIDATOR = new PasswordValidator();

	@Test(expectedExceptions = InvalidPasswordException.class, expectedExceptionsMessageRegExp=".*"+PasswordValidator.PASSWORD_SHOULD_CONTAIN_UPPERCASE_LETTER)
	public void shouldContainAtLeastOneCapitalLetter() throws InvalidPasswordException {

		PASSWORD_VALIDATOR.validate(PASSWORD_WITHOUT_CAPITAL_LETTER);
	}

	@Test
	public void shouldContainAtLeastOneDigitLetter() throws InvalidPasswordException {
		catchException(PASSWORD_VALIDATOR).validate(PASSWORD_WITHOUT_DIGITS);

		assertTrue((caughtException() instanceof InvalidPasswordException));
		assertTrue(caughtException().getMessage().contains(PasswordValidator.PASSWORD_SHOULD_CONTAIN_DIGIT));

	}

	@Test
	public void shouldBeAtLeast6CharLong() throws InvalidPasswordException {
		
		catchException(PASSWORD_VALIDATOR).validate(PASSWORD_TOO_SHORT);
		
		// then: we expect an IndexOutOfBoundsException
		then(caughtException())
		        .isInstanceOf(InvalidPasswordException.class)
		        .hasMessage("invalid password: [" + PASSWORD_TOO_SHORT + "]." + PasswordValidator.PASSWORD_SHOULD_BE_6_CHAR_LONG);
	}

	@Test
	public void shouldAllowPasswordWith6Chars() throws InvalidPasswordException {
		PASSWORD_VALIDATOR.validate(PASSWORD_WITH_6_CHARS);
	}
}
