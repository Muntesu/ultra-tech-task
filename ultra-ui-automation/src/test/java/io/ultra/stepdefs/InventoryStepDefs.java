package io.ultra.stepdefs;

import io.cucumber.java.en.When;
import io.ultra.actions.InventoryActions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InventoryStepDefs {
	private final InventoryActions inventoryActions;

	@When("user adds to cart a product from inventory page")
	public void addProductToCart() {
		inventoryActions.addProductToCart();
	}
	@When("user adds to cart several products from inventory page")
	public void addSeveralProductsToCart() {
		inventoryActions.addProductToCart();
		inventoryActions.addProductToCart();
	}
}
