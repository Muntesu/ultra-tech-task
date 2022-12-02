package io.ultra.core.context;

import io.cucumber.spring.ScenarioScope;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ScenarioScope
public class TestContext {
	private final Map<ContextKey, Object> DATA = new ConcurrentHashMap<>();

	public void cleanup() {
		DATA.clear();
	}

	public void save(ContextKey key, Object value) {
		DATA.put(key, value);
	}

	public <T> T get(ContextKey key, Class<T> clazz) {
		return clazz.cast(DATA.get(key));
	}

	@SneakyThrows
	public <T> T getOrCreate(ContextKey key, Class<T> clazz) {
		T t = get(key, clazz);
		if (t != null)
			return t;

		Constructor<T> ctor = clazz.getConstructor();
		T newInstance = ctor.newInstance();
		save(key, newInstance);
		return newInstance;
	}

	public void remove(ContextKey key) {
		DATA.remove(key);
	}
}