package io.ultra.pom.pages.thank_you;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;
import io.ultra.pom.base.BasePage;

public interface ThankYouPage extends BasePage {
	@FindBy(".//h2[@class='complete-header']")
	BaseElement successMessage();
}
