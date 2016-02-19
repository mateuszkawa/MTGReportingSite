package security.authentication;

public interface Authentication {
	
	public boolean authenticate(String login, String password);
	
}
