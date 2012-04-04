package practicalunittesting.ch4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	//alternatively you can create one regex: http://yacsharpblog.blogspot.com/2008/09/regular-expression-alternations.html
	public static final String PASSWORD_SHOULD_BE_6_CHAR_LONG="Password should be at least 6 char. long";
	public static final String PASSWORD_SHOULD_CONTAIN_UPPERCASE_LETTER="Pasword should contain at least one uppercase letter";
	public static final String PASSWORD_SHOULD_CONTAIN_DIGIT="Passowrd should contain at least one digit";
	
	private static Pattern atLeasOneUppercasePattern = Pattern.compile("(.*[A-Z].*)");
	private static Pattern atLeastOneDigitPattern = Pattern.compile("(.*[0-9].*)");
	private static Pattern atLeast6CharLongPattern = Pattern.compile("(.{6,})");
	
	public static void validate(String password) throws InvalidPasswordException {
		Matcher matcher1 = atLeasOneUppercasePattern.matcher(password);
		if (!matcher1.find()) {
			throw new InvalidPasswordException("invalid password: [" + password + "]. " + PASSWORD_SHOULD_CONTAIN_UPPERCASE_LETTER);
		}
		Matcher matcher2 = atLeastOneDigitPattern.matcher(password);
		if (!matcher2.find()) {
			throw new InvalidPasswordException("invalid password: [" + password + "]. " + PASSWORD_SHOULD_CONTAIN_DIGIT);
		}
		Matcher matcher3 = atLeast6CharLongPattern.matcher(password);
		if (!matcher3.find()) {
			throw new InvalidPasswordException("invalid password: [" + password + "]." + PASSWORD_SHOULD_BE_6_CHAR_LONG);
		}
	}

}
