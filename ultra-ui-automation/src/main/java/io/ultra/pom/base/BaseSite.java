package io.ultra.pom.base;


import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import io.ultra.pom.pages.cart.CartPage;
import io.ultra.pom.pages.inventory.InventoryPage;
import io.ultra.pom.pages.login.LogInPage;

public interface BaseSite extends WebSite {
	@Page(url = "")
	LogInPage loginPage();

	@Page(url = "/inventory.html")
	InventoryPage invenotryPage();

	@Page(url = "/cart.html")
	CartPage cartPage();

}
