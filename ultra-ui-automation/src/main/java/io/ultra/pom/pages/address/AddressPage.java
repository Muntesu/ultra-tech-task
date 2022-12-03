package io.ultra.pom.pages.address;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;
import io.ultra.pom.base.BasePage;

public interface AddressPage extends BasePage {
	@FindBy(".//input[@id='first-name']")
	BaseElement firstName();

	@FindBy(".//input[@id='last-name']")
	BaseElement lastName();

	@FindBy(".//input[@id='postal-code']")
	BaseElement zip();

	@FindBy(".//input[@id='continue']")
	BaseElement continueBtn();
}
