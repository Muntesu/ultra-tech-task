package io.ultra.core.config;

import io.ultra.dto.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "users")
@Getter
@Setter
public class UserConfig {
	private List<User> users;
}

