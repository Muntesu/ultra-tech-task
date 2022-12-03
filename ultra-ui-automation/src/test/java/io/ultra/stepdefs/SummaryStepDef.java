package io.ultra.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.ultra.actions.SummaryActions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SummaryStepDef {
	private final SummaryActions summaryActions;

	@Given("summary page with proper info is shown")
	public void summaryPageContainsProperData() {
		summaryActions.checkSummaryContainsProperData();
	}

	@When("user submits the order")
	public void submitOrder() {
		summaryActions.submitOrder();
	}
}
