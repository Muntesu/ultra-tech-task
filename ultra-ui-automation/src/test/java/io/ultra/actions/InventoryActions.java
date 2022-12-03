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
import java.util.ArrayList;
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
		ProductCard productCard = getRandomProductCard();
		saveProductContext(productCard);
		productCard.addToCart().click();
	}

	private ProductCard getRandomProductCard() {
		InventoryPage inventoryPage = atlasActions.getPage(InventoryPage.class);
		inventoryPage.products().should(hasSize(not(0)));

		//Logic for picking up unique item (remember indexes that were already used)
		ArrayList usedIndexes = testContext.getOrCreate(ContextKey.PRODUCT_ITEM_INDEXES, ArrayList.class);
		int index;

		if (usedIndexes.size() >= inventoryPage.products().size())
			throw new RuntimeException("There are no products left");

		do {
			index = new Random().nextInt(inventoryPage.products().size());
		} while (usedIndexes.contains(index));

		usedIndexes.add(index);
		return inventoryPage.products().get(index);
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

	public void openRandomProduct() {
		getRandomProductCard().name().click();
	}
}
