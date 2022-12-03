package io.ultra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.money.MonetaryAmount;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String name;
	private String description;
	private MonetaryAmount price;
	private Integer quantity;
}
