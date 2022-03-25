package com.epam.BDDHomeTask.pageobject.pages;

import com.epam.BDDHomeTask.pageobject.BasePage;
import com.epam.BDDHomeTask.pageobject.modules.SortingDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'a-size-base-plus a-color-base a-text-normal')]")
    private List<WebElement> titles;

    @FindBy(xpath = "//*[contains(@class, 'a-price-whole')]")
    private List<WebElement> pricesWhole;

    @FindBy(xpath = "//*[contains(@class, 'a-price-fraction')]")
    private List<WebElement> pricesFraction;

    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CategoryPage pickBrand(String brand_name) {
        WebElement brand = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"" + brand_name + "\"]")));
        brand.click();
        return this;
    }

    public List<WebElement> getTitles() {
        return titles;
    }

    public CategoryPage pickPriceRange(String priceRange) {
        WebElement price = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"" + priceRange + "\"]")));
        price.click(); //Picking price range under 25$
        return this;
    }

    public List<Float> getFullPrices() {
        List<Float> fullPrices = new ArrayList<>();
        for (int i = 0; i < pricesFraction.size(); i++) {
            String whole = pricesWhole.get(i).getText();
            String fraction = pricesFraction.get(i).getText();
            String fullString = whole + "." + fraction;
            float fullFloat = Float.parseFloat(fullString);
            fullPrices.add(fullFloat);
        }
        return fullPrices;
    }

    public SortingDropDown openSortingDropDown() {
        WebElement sortingDropDown = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("a-autoid-0-announce")));
        sortingDropDown.click();
        return new SortingDropDown(webDriver);
    }


}
