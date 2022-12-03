package io.ultra.pom.pages.inventory.components;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;

public interface ProductCard extends BaseElement {
	@FindBy(".//div[@class='inventory_item_label']/a")
	BaseElement name();

	@FindBy(".//div[@class='inventory_item_desc']")
	BaseElement description();

	@FindBy(".//div[@class='inventory_item_price']")
	BaseElement price();

	@FindBy(".//button[contains(@id,'remove')]")
	BaseElement remove();

	@FindBy(".//button[contains(@id,'add-to-cart')]")
	BaseElement addToCart();
}
