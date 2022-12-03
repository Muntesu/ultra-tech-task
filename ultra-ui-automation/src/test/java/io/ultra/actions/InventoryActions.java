package io.ultra.actions;

import io.ultra.core.context.ContextKey;
import io.ultra.core.context.TestContext;
import io.ultra.dto.Cart;
import io.ultra.dto.Product;
import io.ultra.pom.pages.inventory.InventoryPage;
import io.ultra.pom.pages.inventory.components.ProductCard;
import io.ultra.util.MoneyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.money.MonetaryAmount;
import java.util.Random;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

@Component
@AllArgsConstructor
public class InventoryActions {
	private final AtlasActions atlasActions;
	private final MoneyUtils moneyUtils;
	private final TestContext testContext;


	public void addProductToCart() {
		InventoryPage inventoryPage = atlasActions.getPage(InventoryPage.class);
		inventoryPage.products().should(hasSize(not(0)));

		int index = new Random().nextInt(inventoryPage.products().size());

		ProductCard productCard = inventoryPage.products().get(index);
		saveProductContext(productCard);
		productCard.addToCart().click();
	}

	public void saveProductContext(ProductCard productCard) {
		String name = productCard.name().getText();
		String desc = productCard.description().getText();
		MonetaryAmount price = moneyUtils.parsePrice(productCard.price().getText());

		Cart cart = testContext.getOrCreate(ContextKey.CART, Cart.class);

		cart.getProducts().add(new Product()
				.withName(name)
				.withDescription(desc)
				.withPrice(price)
				.withQuantity(1));
	}
}
