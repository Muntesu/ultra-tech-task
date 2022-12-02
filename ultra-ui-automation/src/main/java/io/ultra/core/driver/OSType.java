package io.ultra.core.driver;

import io.github.bonigarcia.wdm.config.OperatingSystem;
import lombok.Getter;

import static java.lang.String.format;
import static java.util.stream.Stream.of;
import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

@Getter
public enum OSType {

	WINDOWS("windows", OperatingSystem.WIN),
	MAC("OS X", OperatingSystem.MAC),
	IOS("iOS", null),
	ANDROID("android", null),
	LINUX("linux", OperatingSystem.LINUX);

	private final String name;
	private final OperatingSystem driverManagerOS;

	OSType(String name, OperatingSystem driverManagerOS) {
		this.name = name;
		this.driverManagerOS = driverManagerOS;
	}

	public static OSType detect() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win")) {
			return WINDOWS;
		} else if (osName.contains("nix") || osName.contains("nux")) {
			return LINUX;
		} else if (osName.contains("mac")) {
			return MAC;
		} else {
			throw new RuntimeException(format("[%s] OS does not match with any of types in the [%s] enum",
					osName, OSType.class.getSimpleName()));
		}
	}

	public static OSType get(String osName) {
		return of(OSType.values())
				.filter(osType -> equalsIgnoreCase(osType.getName(), osName))
				.findFirst()
				.orElseThrow(() ->
						new RuntimeException(format("[%s] os does not match with any of types in the [%s] enum",
								osName, OSType.class.getSimpleName())));
	}
}

