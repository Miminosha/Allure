package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertyTest1() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }


    @Test
    void simplePropertyTest2() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }


    @Test
    void simplePropertyTest3() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("properties")
    void simplePropertyTest4() {
        String browserName = System.getProperty("browser_name", "firefox");
        String browserVersion = System.getProperty("browser_version", "101");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);

    }

    @Test
    @Tag("hello")
    void simplePropertyTest5() {
        System.out.println("Hello, " + System.getProperty("some_text", "qa.guru"));
    }
}
