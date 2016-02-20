package pages.login.validators;

import com.vaadin.data.validator.AbstractValidator;

public class PasswordValidator extends AbstractValidator<String>{

	private static final long serialVersionUID = 8903804464981415269L;

	public PasswordValidator() {
        super("The password provided is not valid. Should be at least 6 char long.");
    }

	@Override
	protected boolean isValidValue(String value) {
		if(value == null) {
			return false;
		}
		//Password must be at least 6 char long
		else if(value.length() < 6){
			return false;
		}
		return true;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}

}
