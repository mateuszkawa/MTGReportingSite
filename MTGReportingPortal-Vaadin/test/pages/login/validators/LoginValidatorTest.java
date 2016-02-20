package pages.login.validators;

import static org.junit.Assert.*;

import org.junit.*;

public class LoginValidatorTest {

	private LoginValidator loginValidator;
	
	@Before
	public void setUp() throws Exception {
		loginValidator = new LoginValidator();
	}

	@Test
	public void nullHandlerTest() {
		assertEquals(false, loginValidator.isValidValue(null));
	}
	
	@Test
	public void emptyValueTest() {
		assertEquals(false, loginValidator.isValidValue(""));
	}
}
