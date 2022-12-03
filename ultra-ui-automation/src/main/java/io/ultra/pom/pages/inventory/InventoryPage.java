package io.ultra.pom.pages.inventory;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BasePage;
import io.ultra.pom.pages.inventory.components.ProductCard;

public interface InventoryPage extends BasePage {

	@FindBy(".//div[@class='inventory_item']")
	ElementsCollection<ProductCard> products();
}
