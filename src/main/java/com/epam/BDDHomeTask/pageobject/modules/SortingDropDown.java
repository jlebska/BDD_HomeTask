package com.epam.BDDHomeTask.pageobject.modules;

import com.epam.BDDHomeTask.pageobject.BasePage;
import com.epam.BDDHomeTask.pageobject.pages.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortingDropDown extends BasePage {

    public SortingDropDown(WebDriver webDriver) {
        super(webDriver);
    }

    public CategoryPage setSortingHighToLow() {
        WebElement sortingPick = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("s-result-sort-select_2")));
        sortingPick.click(); //Sorting High to Low
        return new CategoryPage(webDriver);
    }
}
