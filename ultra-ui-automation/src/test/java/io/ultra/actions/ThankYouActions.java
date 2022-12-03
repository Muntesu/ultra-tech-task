package io.ultra.actions;

import io.ultra.pom.pages.thank_you.ThankYouPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static io.ultra.dto.GlobalConsts.PAGE_LOAD_TIMEOUT;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

@Component
@AllArgsConstructor
public class ThankYouActions {
	private final AtlasActions atlasActions;

	public void checkThankYouPageIsShown() {
		getThankYouPage().successMessage().should(displayed(), PAGE_LOAD_TIMEOUT);
	}

	private ThankYouPage getThankYouPage() {
		return atlasActions.getPage(ThankYouPage.class);
	}
}
