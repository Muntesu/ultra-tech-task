package io.ultra.core.context;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContextKey {
	CART("Cart"),
	ADDRESS("Address"), 
	PRODUCT_ITEM_INDEXES("Product item indexes");

	final String name;
}
