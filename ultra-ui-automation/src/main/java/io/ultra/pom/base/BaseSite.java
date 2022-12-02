package io.ultra.pom.base;


import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;

public interface BaseSite extends WebSite {
	@Page()
	HomePage homePage();

}
