package io.ultra.core.driver;

import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.ultra.core.config.EnvConfig;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.String.format;

@Configuration
@AllArgsConstructor
public class DriverConfiguration {

	private final EnvConfig envConfig;

	@Bean
	@ScenarioScope
	public WebDriver setUpDriver() {
		return instantiateLocalDriver("--start-maximized",
				"--disable-notifications",
				"--ignore-certificate-errors");
	}

	private WebDriver instantiateLocalDriver(String... arguments) {
		Browser browser = envConfig.getBrowser();
		setUpDriverExecutable(browser.getDriverManagerType());
		return switch (browser) {
			case CHROME -> new ChromeDriver(new ChromeOptions().addArguments(arguments));
			case FIREFOX -> new FirefoxDriver(new FirefoxOptions().addArguments(arguments));
			case SAFARI -> new SafariDriver(new SafariOptions());
			default ->
					throw new RuntimeException(format("Unable to create a new instance of driver for %s browser", browser.getName()));
		};
	}

	private void setUpDriverExecutable(DriverManagerType driverType) {
		WebDriverManager.getInstance(driverType).operatingSystem(OSType.detect().getDriverManagerOS()).setup();
	}
}
