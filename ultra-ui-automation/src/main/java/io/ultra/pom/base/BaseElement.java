package io.ultra.pom.base;

import io.qameta.atlas.webdriver.AtlasWebElement;

public interface BaseElement extends AtlasWebElement<BaseElement> {
	boolean isPresent();
}
