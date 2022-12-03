package io.ultra.pom.pages.login;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.ultra.pom.base.BaseElement;
import io.ultra.pom.base.BasePage;

public interface LogInPage extends BasePage {
	@FindBy(".//input[@id='user-name']")
	BaseElement userName();

	@FindBy(".//input[@id='password']")
	BaseElement password();

	@FindBy(".//input[@id='login-button']")
	BaseElement login();
}
