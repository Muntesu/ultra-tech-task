package io.ultra.pom.pages.cart;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;
import io.ultra.pom.base.BasePage;
import io.ultra.pom.pages.cart.components.ProductRow;

public interface CartPage extends BasePage {

	@FindBy(".//div[@class='cart_item']")
	ElementsCollection<ProductRow> productRows();

	@FindBy(".//button[@id='checkout']")
	BaseElement checkout();
}
