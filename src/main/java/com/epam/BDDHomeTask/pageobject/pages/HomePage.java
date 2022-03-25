package com.epam.BDDHomeTask.pageobject.pages;

import com.epam.BDDHomeTask.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage open() {
        webDriver.get("https://www.amazon.com/");
        return this;
    }

    public CategoryPage openCategory(String category_name) {
        WebElement category = webDriver.findElement(By.xpath("//*[contains(@aria-label,\"" + category_name + "\")]"));
        category.click();
        return new CategoryPage(webDriver);
    }
}
