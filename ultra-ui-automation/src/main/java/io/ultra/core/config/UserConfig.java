package io.ultra.core.config;

import io.ultra.dto.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.Name;

@ConfigurationProperties("users")
@Getter
@Setter
@ConstructorBinding
public class UserConfig {
	private User standardUser;

	public UserConfig(@Name("standard_user") User user) {
		standardUser = user;
	}
}

