package io.ultra.core.context;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContextKey {
	PROPERTY_EXAMPLE("Property example");

	final String name;
}
