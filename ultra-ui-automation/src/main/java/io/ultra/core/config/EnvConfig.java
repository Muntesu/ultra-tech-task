package io.ultra.core.config;

import io.ultra.core.driver.Browser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.Name;

@ConstructorBinding
@ConfigurationProperties(prefix = "env")
@Getter
@Setter
public class EnvConfig {
    private final String baseUrl;
    private final Browser browser;

    public EnvConfig(@Name("base_url") String baseUrl, @Name("browser") String browser) {
        this.baseUrl = baseUrl;
        this.browser = Browser.get(browser);
    }
}

