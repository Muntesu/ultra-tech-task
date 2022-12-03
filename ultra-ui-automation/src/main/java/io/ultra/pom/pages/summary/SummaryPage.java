package io.ultra.pom.pages.summary;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;
import io.ultra.pom.base.BasePage;
import io.ultra.pom.pages.cart.components.ProductRow;

public interface SummaryPage extends BasePage {
	@FindBy(".//div[@class='cart_item']")
	ElementsCollection<ProductRow> productRows();

	@FindBy(".//div[contains(@class,'info_label') and contains(.,'Payment')]/following-sibling::div[1]")
	BaseElement paymentInfo();

	@FindBy(".//div[contains(@class,'info_label') and contains(.,'Shipping')]/following-sibling::div[1]")
	BaseElement shippingInfo();

	@FindBy(".//div[@class='summary_subtotal_label']")
	BaseElement itemTotal();

	@FindBy(".//div[@class='summary_tax_label']")
	BaseElement tax();

	@FindBy(".//div[@class='summary_total_label']")
	BaseElement total();

	@FindBy(".//button[@id='cancel']")
	BaseElement cancel();

	@FindBy(".//button[@id='finish']")
	BaseElement finish();
}
