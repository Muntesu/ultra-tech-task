package io.ultra.actions;

import io.qameta.atlas.core.Atlas;
import io.ultra.pom.base.HomePage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AtlasActions {
	private final Atlas atlas;
	private final WebDriver driver;


	@SneakyThrows
	public void openPage() {
		HomePage homePage = atlas.create(driver, HomePage.class);
		homePage.open();
		Thread.sleep(1000); //just to see if page really opens
	}
}
