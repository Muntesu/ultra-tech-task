package io.ultra.util;

import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest
@AllArgsConstructor
public class Hooks {
	private final WebDriver webDriver;


	@After(order = 1)
	@SneakyThrows
	public void closeBrowser() {
		webDriver.quit();
	}
}
