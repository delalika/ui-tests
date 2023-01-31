package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.utils.ConfigLoader;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void load(String endpoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint);
    }
}
