package io.ultra.actions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TestAction {
	private final AtlasActions atlasActions;

	public void openPage() {
		atlasActions.openPage();
	}
}
