package pages.login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import pages.login.main.SimpleLoginMainView;
import pages.login.validators.LoginValidator;
import pages.login.validators.PasswordValidator;
import security.authentication.AuthenticationImpl;

public class SimpleLoginView extends CustomComponent implements View, ClickListener{

	private static final long serialVersionUID = -3466529637160182311L;

	public static final String NAME = "login";

    private final TextField userTextField;

    private final PasswordField passwordField;

    private final Button loginButton;

    public SimpleLoginView() {
    	setSizeFull();
    	
    	// Create the user input field
    	userTextField = new TextField("User name: ");
    	userTextField.setWidth("300px");
    	userTextField.setRequired(true);
    	userTextField.setInputPrompt("Your username (eg. user1)");
    	userTextField.addValidator(new LoginValidator());
    	userTextField.setInvalidAllowed(false);
    	
    	// Create the password input field
    	passwordField = new PasswordField("Password:");
        passwordField.setWidth("300px");
        passwordField.setRequired(true);
        passwordField.addValidator(new PasswordValidator());
        passwordField.setValue("");
        passwordField.setNullRepresentation("");

        // Create login button
        loginButton = new Button("Login", this);

        // Add all to a panel
        VerticalLayout fields = new VerticalLayout(userTextField, passwordField, loginButton);
        fields.setCaption("Please login to access the application. (user1/password)");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(fields);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);
    }
	
	@Override
	public void enter(ViewChangeEvent event) {
		// focus the username field when user arrives to the login view
		userTextField.focus();
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (!userTextField.isValid() || !passwordField.isValid()) {
            return;
        }
		
		AuthenticationImpl auth = new AuthenticationImpl();
		boolean isValid = auth.authenticate(userTextField.getValue(), passwordField.getValue());
		
		if(isValid) {
			//set session parameters
			getSession().setAttribute("user", userTextField.getValue());
			
			// Navigate to main view
            getUI().getNavigator().navigateTo(SimpleLoginMainView.NAME);
		}
		else {
			passwordField.setValue(null);
			passwordField.focus();
		}
	}

}
