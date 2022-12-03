package io.ultra.actions;

import io.ultra.core.context.ContextKey;
import io.ultra.core.context.TestContext;
import io.ultra.dto.Cart;
import io.ultra.dto.Product;
import io.ultra.pom.pages.pdp.PdpPage;
import io.ultra.util.MoneyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.money.MonetaryAmount;

@Component
@AllArgsConstructor
public class PdpActions {
	private final AtlasActions atlasActions;
	private final MoneyUtils moneyUtils;
	private final TestContext testContext;


	public void addProductToCart() {
		saveProductContext();
		getPdpPage().addToCart().click();
	}


	public void saveProductContext() {
		PdpPage pdpPage = getPdpPage();
		String name = pdpPage.name().getText();
		String desc = pdpPage.desc().getText();
		MonetaryAmount price = moneyUtils.parsePrice(pdpPage.price().getText());

		Cart cart = testContext.getOrCreate(ContextKey.CART, Cart.class);

		cart.getProducts().add(new Product()
				.withName(name)
				.withDescription(desc)
				.withPrice(price)
				.withQuantity(1));
	}

	private PdpPage getPdpPage() {
		return atlasActions.getPage(PdpPage.class);
	}
}
