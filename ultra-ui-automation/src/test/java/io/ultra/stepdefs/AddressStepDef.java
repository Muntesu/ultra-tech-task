package io.ultra.stepdefs;


import io.cucumber.java.en.When;
import io.ultra.actions.AddressActions;
import io.ultra.dto.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressStepDef {
	private final AddressActions addressActions;

	@When("user submits address from with")
	public void submitAddressForm(Address address) {
		addressActions.submitAddress(address);
	}

	@When("address validation messages are displayed")
	public void checkValidationMessagesAreDisplayed() {
		addressActions.checkValidationDisplayed();
	}


}
