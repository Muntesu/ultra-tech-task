package io.ultra;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"io.ultra"})
@EntityScan(basePackages = {"io.ultra"})
@ConfigurationPropertiesScan
public class SpringBootCucumberApplication {

}
