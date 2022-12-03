package io.ultra.actions;

import io.ultra.core.context.TestContext;
import io.ultra.dto.Cart;
import io.ultra.dto.Product;
import io.ultra.pom.pages.cart.CartPage;
import io.ultra.util.MoneyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.ultra.core.context.ContextKey.CART;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Component
@AllArgsConstructor
public class CartActions {
	private final AtlasActions atlasActions;
	private final TestContext testContext;
	private final MoneyUtils moneyUtils;


	public void openCartPage() {
		atlasActions.getSite().cartPage();
	}

	public void validateCartProducts() {
		List<Product> expectedProducts = testContext.get(CART, Cart.class).getProducts();
		CartPage page = getCartPage();
		List<Product> actualProducts = page.productRows().extract(el -> new Product()
				.withName(el.name().getText())
				.withDescription(el.description().getText())
				.withPrice(moneyUtils.parsePrice(el.price().getText()))
				.withQuantity(Integer.parseInt(el.quantity().getText()))).stream().toList();

		assertThat("Cart contains different set of products", actualProducts, is(expectedProducts));
	}

	public void clickCheckout() {
		getCartPage().checkout().click();
	}

	private CartPage getCartPage() {
		return atlasActions.getPage(CartPage.class);
	}
}
