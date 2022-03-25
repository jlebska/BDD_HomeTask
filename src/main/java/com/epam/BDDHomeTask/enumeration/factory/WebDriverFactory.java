package com.epam.BDDHomeTask.enumeration.factory;

import com.epam.BDDHomeTask.properties.converters.SupportedBrowserConverter;
import com.epam.BDDHomeTask.properties.holders.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver(){
        return SupportedBrowserConverter.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
