package pages.login.validators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PasswordValidatorTest {

	private PasswordValidator passwordValidator;
	
	@Before
	public void setUp() throws Exception {
		passwordValidator = new PasswordValidator();
	}

	@Test
	public void nullHandlerTest() {
		assertEquals(false, passwordValidator.isValidValue(null));
	}
	
	@Test
	public void emptyValueTest() {
		assertEquals(false, passwordValidator.isValidValue(""));
	}
	
	@Test
	public void lessThanSixLiteralsTest() {
		for(int i = 1; i < 6; i++){
			assertEquals(false, passwordValidator.isValidValue(getRandomString(i)));
		}
	}
	
	@Test
	public void sixLiteralsTest() {
		assertEquals(true, passwordValidator.isValidValue(getRandomString(6)));
	}
	
	private String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++){
			sb.append("a");
		}
		return sb.toString();
	}

}
