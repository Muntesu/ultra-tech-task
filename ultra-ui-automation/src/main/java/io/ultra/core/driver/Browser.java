package io.ultra.core.driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.Getter;

import static java.lang.String.format;
import static java.util.stream.Stream.of;
import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

@Getter
public enum Browser {

    CHROME("chrome", DriverManagerType.CHROME),
    FIREFOX("firefox", DriverManagerType.FIREFOX),
    SAFARI("safari", DriverManagerType.SAFARI),
    EDGE("edge", DriverManagerType.EDGE);

    private final String name;
    private final DriverManagerType driverManagerType;

    Browser(String name, DriverManagerType driverManagerType) {
        this.name = name;
        this.driverManagerType = driverManagerType;
    }

    public static Browser get(String browserName) {
        return of(Browser.values())
                .filter(browser -> equalsIgnoreCase(browser.name(), browserName))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(format("[%s] browser does not match with any of types in the [%s] enum",
                                browserName, Browser.class.getSimpleName())));
    }
}

