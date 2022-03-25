package com.epam.BDDHomeTask.steps;


import com.epam.BDDHomeTask.enumeration.factory.WebDriverFactory;
import com.epam.BDDHomeTask.pageobject.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static final Map<String, BasePage> PAGES_STORAGE = new HashMap<>();
    public static WebDriver webDriver;

    @Before
    public void initWebDriver() {
        webDriver = new WebDriverFactory().getWebDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        webDriver.close();
        webDriver.quit();
    }
}
