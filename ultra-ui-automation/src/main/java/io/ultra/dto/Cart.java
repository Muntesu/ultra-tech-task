package io.ultra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private List<Product> products = new ArrayList();

	public MonetaryAmount getItemTotal(){
		CurrencyUnit currency = products.get(0).getPrice().getCurrency();
		return products.stream().map(el -> el.getPrice().multiply(el.getQuantity())).reduce(Money.of(0, currency), MonetaryAmount::add);
	}
}
