package io.ultra.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.ultra.actions.CartActions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartStepDef {
	private CartActions cartActions;

	@When("user opens cart page")
	public void openCartPage() {
		cartActions.openCartPage();
	}

	@Given("product is saved in the cart")
	public void productIsSavedInTheCart() {
		cartActions.validateCartProducts();
	}

	@When("user proceeds to checkout step one")
	public void proceedToNextCheckoutStep() {
		cartActions.clickCheckout();
	}
}
