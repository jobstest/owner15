package tests;

import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTests extends TestBase {
    WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @Test
    void testLocal() {
        System.setProperty("owner", "local");

        assertThat(webDriverConfig.getBrowser()).isEqualTo("chrome");
        assertThat(webDriverConfig.getVersion()).isEqualTo("104");
    }

    @Test
    void testRemoute() {
        System.setProperty("owner", "remote");

        assertThat(webDriverConfig.getBrowser()).isEqualTo("chrome");
        assertThat(webDriverConfig.getVersion()).isEqualTo("104");
        assertThat(webDriverConfig.getRemoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}
