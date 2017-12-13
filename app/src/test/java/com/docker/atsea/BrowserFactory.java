package com.docker.atsea;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class BrowserFactory {

    private static WebDriver instance;

    public static synchronized WebDriver getInstance(){
        if(instance == null) {
            System.setProperty("webdriver.chrome.driver", "/Users/sarndeep/RubymineProjects/dockerDemo/atsea-sample-shop-app/app/src/test/resources/chromedriver");
            Capabilities chrome = DesiredCapabilities.chrome();
            instance = WebDriverPool.DEFAULT.getDriver(chrome);
        }
        return instance;
    }
}
