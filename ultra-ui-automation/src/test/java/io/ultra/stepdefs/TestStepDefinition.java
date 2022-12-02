package io.ultra.stepdefs;

import io.cucumber.java.en.Given;
import io.ultra.actions.TestAction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TestStepDefinition {
	private final TestAction testAction;

	@Given("I open google")
	public void iOpenGoogle() {
		testAction.openPage();
	}
}
