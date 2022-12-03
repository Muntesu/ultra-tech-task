package io.ultra.actions;

import io.ultra.core.context.TestContext;
import io.ultra.dto.Address;
import io.ultra.pom.pages.address.AddressPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static io.ultra.core.context.ContextKey.ADDRESS;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

@AllArgsConstructor
@Component
public class AddressActions {
	private final AtlasActions atlasActions;
	private final TestContext testContext;


	public void submitAddress(Address address) {
		AddressPage addrPage = getAddressPage();
		fillAddressForm(address);
		addrPage.continueBtn().click();

		saveAddressContext(address);
	}

	public void fillAddressForm(Address address) {
		AddressPage addressPage = getAddressPage();
		addressPage.firstName().sendKeys(address.getFirstName());
		addressPage.lastName().sendKeys(address.getLastName());
		addressPage.zip().sendKeys(address.getZip());
	}

	public void checkValidationDisplayed() {
		getAddressPage().error().should("Address Error message was not displayed",displayed());
	}

	private void saveAddressContext(Address address) {
		testContext.save(ADDRESS, address);
	}

	private AddressPage getAddressPage() {
		return atlasActions.getPage(AddressPage.class);
	}
}
