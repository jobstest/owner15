package provider;

import config.Browser;
import config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private WebDriverConfig webDriverConfig;

    public WebDriverProvider() {
        this.webDriverConfig = ConfigFactory.create(WebDriverConfig.class,System.getProperties());
    }


    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(webDriverConfig.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (webDriverConfig.getBrowser().equals(Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        if (webDriverConfig.getBrowser().equals(Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        throw new RuntimeException("no such browser");
    }
}
