package io.ultra.actions;

import io.ultra.core.context.TestContext;
import io.ultra.dto.Cart;
import io.ultra.dto.Product;
import io.ultra.pom.pages.cart.CartPage;
import io.ultra.pom.pages.cart.components.ProductRow;
import io.ultra.util.MoneyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.ultra.core.context.ContextKey.CART;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.matchers.webdriver.EnabledMatcher.enabled;

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

	public void removeAProduct() {
		ProductRow productRow = getCartPage().productRows().get(0);
		String productNameToRemove = productRow.name().getText();
		productRow.remove().click();
		List<Product> savedProducts = testContext.get(CART, Cart.class).getProducts();
		//Removing product from context
		savedProducts.remove(
				savedProducts.stream()
						.filter(el -> el.getName().equals(productNameToRemove))
						.findFirst()
						.orElseThrow(() -> new RuntimeException("There is no such product in test context"))
		);
	}

	public void checkCheckoutButtonIsDisabled() {
		getCartPage().checkout().should("Checkout button should be disabled", not(enabled()), 1);
	}
}
