package io.ultra.pom.pages.pdp;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;
import io.ultra.pom.base.BasePage;

public interface PdpPage extends BasePage {

	@FindBy(".//div[contains(@class,\"inventory_details_name\")]")
	BaseElement name();

	@FindBy(".//div[contains(@class,\"inventory_details_desc \")]")
	BaseElement desc();

	@FindBy(".//div[contains(@class,\"inventory_details_price\")]")
	BaseElement price();

	@FindBy(".//button[contains(@id,\"add-to-cart\")]")
	BaseElement addToCart();
}
