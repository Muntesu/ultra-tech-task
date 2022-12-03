package io.ultra.stepdefs;

import io.cucumber.java.en.When;
import io.ultra.actions.InventoryActions;
import io.ultra.actions.PdpActions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PdpStepDef {
	private final PdpActions pdpActions;
	private final InventoryActions inventoryActions;

	@When("user adds to cart a product from product details page")
	public void addProductToCardFromPdp() {
		inventoryActions.openRandomProduct();
		pdpActions.addProductToCart();
	}

}
