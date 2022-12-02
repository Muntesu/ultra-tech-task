package io.ultra.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features",
		plugin = {"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"summary"},
		glue = {"io.ultra"},
		monochrome = true
)
@SuppressWarnings("NewClassNamingConvention")
public class Runner extends AbstractTestNGCucumberTests {
}
