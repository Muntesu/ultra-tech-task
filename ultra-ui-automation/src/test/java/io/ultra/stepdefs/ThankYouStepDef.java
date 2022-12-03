package io.ultra.stepdefs;

import io.cucumber.java.en.Given;
import io.ultra.actions.ThankYouActions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ThankYouStepDef {
	private final ThankYouActions thankYouActions;

	@Given("thank you page is shown")
	public void thankYouPageIsShown() {
		thankYouActions.checkThankYouPageIsShown();
	}
}
