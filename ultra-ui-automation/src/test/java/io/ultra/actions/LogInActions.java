package io.ultra.actions;

import io.ultra.dto.User;
import io.ultra.pom.pages.login.LogInPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static io.ultra.dto.GlobalConsts.PAGE_LOAD_TIMEOUT;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

@Component
@AllArgsConstructor
public class LogInActions {
	private final AtlasActions atlasActions;

	public void logInAs(User user) {
		openLogInPage();
		submitLogInForm(user);
	}

	public void submitLogInForm(User user) {
		fillLogInForm(user);
		getLogInPage().login().click();
	}

	public void fillLogInForm(User user) {
		LogInPage logInPage = getLogInPage();
		logInPage.userName().sendKeys(user.getUsername());
		logInPage.password().sendKeys(user.getPassword());
	}

	public void openLogInPage() {
		LogInPage logInPage = getLogInPage();
		logInPage.open();
		logInPage.login().should(displayed(), PAGE_LOAD_TIMEOUT);
	}

	private LogInPage getLogInPage() {
		return atlasActions.getPage(LogInPage.class);
	}
}
