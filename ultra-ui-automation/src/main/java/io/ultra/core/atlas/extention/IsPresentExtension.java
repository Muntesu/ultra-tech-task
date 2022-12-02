package io.ultra.core.atlas.extention;

import io.qameta.atlas.core.api.MethodExtension;
import io.qameta.atlas.core.context.TargetContext;
import io.qameta.atlas.core.internal.Configuration;
import io.qameta.atlas.core.util.MethodInfo;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;

import java.lang.reflect.Method;

@Log4j2
public class IsPresentExtension implements MethodExtension {

	@Override
	public Object invoke(Object proxy, MethodInfo methodInfo, Configuration config) {
		try {
			String locatorString = config.requireContext(TargetContext.class).getValue().instance().toString();
			return locatorString != null;
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	@Override
	public boolean test(Method method) {
		return method.getName().equals("isPresent");
	}

}
