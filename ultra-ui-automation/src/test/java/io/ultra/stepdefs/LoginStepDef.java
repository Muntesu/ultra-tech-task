package io.ultra.stepdefs;

import io.cucumber.java.en.Given;
import io.ultra.actions.LogInActions;
import io.ultra.dto.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginStepDef {
	private final LogInActions logInActions;

	@Given("user is logged in as {user}")
	public void userIsLoggedInAs(User user) {
		logInActions.logInAs(user);
	}

}
