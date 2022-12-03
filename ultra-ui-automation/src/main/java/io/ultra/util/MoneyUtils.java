package io.ultra.util;

import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import javax.money.format.MonetaryFormats;
import java.util.Locale;

@Service
public class MoneyUtils {

	public MonetaryAmount parsePrice(String price) {
		if (price.isEmpty())
			throw new RuntimeException("Price string is empty");

		//TODO find a proper way to parse it
		return MonetaryFormats.getAmountFormat(Locale.ENGLISH).parse(price.replace("$", "USD "));
	}
}
