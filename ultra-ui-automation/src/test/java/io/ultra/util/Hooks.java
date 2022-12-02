package io.ultra.util;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.qameta.allure.Allure;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.ByteArrayInputStream;

@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest
@AllArgsConstructor
public class Hooks {
	private final WebDriver webDriver;


	@After(order = 2)
	public void afterStep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Image Attachment", "image/png", new ByteArrayInputStream(screenshot), "png");
		}
	}

	@After(order = 1)
	@SneakyThrows
	public void closeBrowser() {
		webDriver.quit();
	}
}
