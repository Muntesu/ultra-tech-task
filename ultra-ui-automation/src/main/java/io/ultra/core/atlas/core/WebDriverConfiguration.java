package io.ultra.core.atlas.core;

import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.Configuration;
import io.qameta.atlas.core.internal.EmptyRetryer;
import io.qameta.atlas.webdriver.context.WebDriverContext;
import io.qameta.atlas.webdriver.extension.*;
import io.ultra.core.atlas.extention.DefaultMethodExtension;
import org.openqa.selenium.WebDriver;

public class WebDriverConfiguration extends Configuration {

	public WebDriverConfiguration(final WebDriver webDriver) {
		registerContext(new WebDriverContext(webDriver));
		registerContext(new RetryerContext(new EmptyRetryer()));
		registerExtension(new DriverProviderExtension());
		registerExtension(new DefaultMethodExtension());
		registerExtension(new FindByExtension());
		registerExtension(new FindByCollectionExtension());
		registerExtension(new ShouldMethodExtension());
		registerExtension(new WaitUntilMethodExtension());
		registerExtension(new WrappedElementMethodExtension());
		registerExtension(new ExecuteJScriptMethodExtension());
		registerExtension(new PageExtension());
		registerExtension(new FilterCollectionExtension());
		registerExtension(new ToStringMethodExtension());
		registerExtension(new ExtractMethodExtension());
	}

	public WebDriverConfiguration(final WebDriver webDriver, final String baseUrl) {
		this(webDriver);
		System.getProperties().setProperty("ATLAS_WEBSITE_URL", baseUrl);
	}
}
