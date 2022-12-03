package io.ultra.pom.pages.cart.components;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;

public interface ProductRow extends BaseElement {
	@FindBy(".//div[@class='cart_quantity']")
	BaseElement quantity();

	@FindBy(".//a[contains(@id,'item')]")
	BaseElement name();

	@FindBy(".//div[@class='inventory_item_desc']")
	BaseElement description();

	@FindBy(".//div[@class='inventory_item_price']")
	BaseElement price();

	@FindBy(".//button[contains(@id,'remove')]")
	BaseElement remove();
}
