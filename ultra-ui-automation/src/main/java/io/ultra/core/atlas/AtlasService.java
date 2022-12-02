package io.ultra.core.atlas;

import io.cucumber.spring.ScenarioScope;
import io.qameta.atlas.core.Atlas;
import io.ultra.core.atlas.core.WebDriverConfiguration;
import io.ultra.core.atlas.extention.IsPresentExtension;
import io.ultra.core.config.EnvConfig;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ScenarioScope
@AllArgsConstructor
public class AtlasService {
	private final WebDriver webDriver;
	private final EnvConfig envConfig;

	@Bean
	@ScenarioScope
	public Atlas createAtlasInstance() {
		return new Atlas(new WebDriverConfiguration(webDriver, envConfig.getBaseUrl()))
				.extension(new IsPresentExtension());

	}
}
