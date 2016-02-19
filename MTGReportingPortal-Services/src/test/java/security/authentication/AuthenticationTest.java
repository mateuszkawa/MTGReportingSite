package security.authentication;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticationTest {
	
	Authentication auth;

	@Test
	public void authenticateTestUser() {
		auth = new AuthenticationImpl();
		assertTrue(auth.authenticate("testUser", "testPassword"));
	}

}
