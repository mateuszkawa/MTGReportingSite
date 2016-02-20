package pages.login.validators;

import com.vaadin.data.validator.AbstractValidator;

public class LoginValidator extends AbstractValidator<String>{

	private static final long serialVersionUID = -6758657548017044324L;

	public LoginValidator() {
        super("The login provided is not valid.");
    }
	
	@Override
	protected boolean isValidValue(String value) {
		if(value == null){
			return false;
		}
		else if(value.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}

}
