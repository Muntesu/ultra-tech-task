package io.ultra.stepdefs;


import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.ultra.core.config.UserConfig;
import io.ultra.dto.Address;
import io.ultra.dto.User;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ParamsStepDef {
	private final UserConfig userConfig;

	@ParameterType("standard_user")
	public User user(String userType) {
		//TODO more user types to be described when needed
		return userConfig.getStandardUser();
	}

	@DataTableType(replaceWithEmptyString = "[empty]")
	public Address address(Map<String, String> entry) {
		return new Address()
				.withFirstName(entry.get("First Name"))
				.withLastName(entry.get("Last Name"))
				.withZip(entry.get("Zip"));
	}
}
