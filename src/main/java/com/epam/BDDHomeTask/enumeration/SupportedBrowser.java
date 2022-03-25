package com.epam.BDDHomeTask.enumeration;

import com.epam.BDDHomeTask.invoker.WebDriverInvoker;
import com.epam.BDDHomeTask.invoker.implementation.LocalChromeInvoker;
import com.epam.BDDHomeTask.invoker.implementation.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowser {
    LOCAL_CHROME(new LocalChromeInvoker()),
    LOCAL_FIREFOX(new LocalFirefoxInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowser(WebDriverInvoker webDriverInvoker){
        this.webDriverInvoker = webDriverInvoker;
    }


    public WebDriver getWebDriver(){
        return webDriverInvoker.invokeWebDriver();
    }
}
