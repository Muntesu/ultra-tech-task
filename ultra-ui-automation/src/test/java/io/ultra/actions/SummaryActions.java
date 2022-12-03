package io.ultra.actions;

import io.ultra.core.context.TestContext;
import io.ultra.dto.Cart;
import io.ultra.dto.Product;
import io.ultra.pom.pages.summary.SummaryPage;
import io.ultra.util.MoneyUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.money.MonetaryAmount;
import java.util.List;

import static io.ultra.core.context.ContextKey.CART;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@AllArgsConstructor
@Component
public class SummaryActions {
	private final AtlasActions atlasActions;
	private final TestContext testContext;
	private final MoneyUtils moneyUtils;


	public void checkSummaryContainsProperData() {
		checkProducts();
		checkTotals();
	}

	private void checkTotals() {
		Cart cart = testContext.get(CART, Cart.class);
		SummaryPage summaryPage = getSummaryPage();

		MonetaryAmount actualItemTotal = moneyUtils.parsePrice(StringUtils.substringAfter(summaryPage.itemTotal().getText(), ":"));
		MonetaryAmount tax = moneyUtils.parsePrice(StringUtils.substringAfter(summaryPage.tax().getText(), ":"));
		MonetaryAmount actualTotal = moneyUtils.parsePrice(StringUtils.substringAfter(summaryPage.total().getText(), ":"));

		assertThat(actualItemTotal, is(cart.getItemTotal()));
		assertThat(actualTotal, is(cart.getItemTotal().add(tax)));
	}

	private void checkProducts() {
		List<Product> expectedProducts = testContext.get(CART, Cart.class).getProducts();
		SummaryPage summaryPage = getSummaryPage();
		List<Product> actualProducts = summaryPage.productRows().extract(el -> new Product()
				.withName(el.name().getText())
				.withDescription(el.description().getText())
				.withPrice(moneyUtils.parsePrice(el.price().getText()))
				.withQuantity(Integer.parseInt(el.quantity().getText()))).stream().toList();

		assertThat("SummaryPage contains different set of products", actualProducts, is(expectedProducts));
	}

	public void submitOrder() {
		getSummaryPage().finish().click();
	}

	private SummaryPage getSummaryPage() {
		return atlasActions.getPage(SummaryPage.class);
	}
}
