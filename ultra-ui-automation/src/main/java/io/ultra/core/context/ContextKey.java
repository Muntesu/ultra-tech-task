package io.ultra.core.context;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContextKey {
	CART("Cart"),
	ADDRESS("Address");

	final String name;
}
