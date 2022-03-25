package com.epam.BDDHomeTask.invoker.implementation;

import com.epam.BDDHomeTask.invoker.WebDriverInvoker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocalChromeInvoker implements WebDriverInvoker {
    @Override
    public WebDriver invokeWebDriver(){
        WebDriverManager.chromedriver().browserVersion("98").setup();
        return new ChromeDriver();
    }
}
