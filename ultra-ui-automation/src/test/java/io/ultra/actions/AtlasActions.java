package io.ultra.actions;

import io.qameta.atlas.core.Atlas;
import io.ultra.pom.base.BasePage;
import io.ultra.pom.base.BaseSite;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AtlasActions {
	private final Atlas atlas;
	private final WebDriver driver;

	public <T extends BasePage> T getPage(Class<T> pageClass) {
		return atlas.create(driver, pageClass);
	}

	public BaseSite getSite() {
		return atlas.create(driver, BaseSite.class);
	}
}
