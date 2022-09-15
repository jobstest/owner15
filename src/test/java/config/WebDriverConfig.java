package config;
import org.aeonbits.owner.Config;

import java.net.URL;
@Config.Sources({"classpath:resources/${owner}.properties"})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("version")
    @DefaultValue("104")
    String getVersion();

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    URL getRemoteUrl();


}
