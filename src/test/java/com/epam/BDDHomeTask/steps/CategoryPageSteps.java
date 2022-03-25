package com.epam.BDDHomeTask.steps;

import com.epam.BDDHomeTask.pageobject.pages.CategoryPage;
import com.google.common.collect.Comparators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;

import static com.epam.BDDHomeTask.steps.BaseSteps.PAGES_STORAGE;

public class CategoryPageSteps {
    @When("User chooses a brand name {string} on {string}")
    public void userChoosesABrandNameOn(String brandName, String pageName) {
        ((CategoryPage) PAGES_STORAGE.get(pageName)).pickBrand(brandName);
    }

    @Then("All the titles of items contain the brand name {string} on {string}")
    public void allTheTitlesOfItemsContainTheBrandNameOn(String brandName, String pageName) {
        List<WebElement> titles = ((CategoryPage) PAGES_STORAGE.get(pageName)).getTitles();
        for (WebElement w : titles) {
            Assert.assertTrue(w.getText().toLowerCase().contains(brandName.toLowerCase()),
                    "Some titles do not contain the brand name");
        }
    }

    @When("User picks a price range {string} on {string}")
    public void userPicksAPriceRangeOn(String priceRange, String pageName) {
        ((CategoryPage) PAGES_STORAGE.get(pageName)).pickPriceRange(priceRange);
    }

    @Then("All prices are under {string} on {string}")
    public void allPricesAreUnderOn(String priceRangeFloat, String pageName) {
        List<Float> fullPrices = ((CategoryPage) PAGES_STORAGE.get(pageName)).getFullPrices();
        Assert.assertTrue(fullPrices.stream().allMatch(i -> i <= Float.parseFloat(priceRangeFloat)),
                "Some of the prices are not in the selected range");
    }

    @And("User picks sorting by price high to low on {string}")
    public void userPicksSortingByPriceHighToLowOn(String pageName) {
        ((CategoryPage) PAGES_STORAGE.get(pageName)).openSortingDropDown().setSortingHighToLow();
    }

    @Then("The prices of visible items are sorted in a correct way on {string}")
    public void thePricesOfVisibleItemsAreSortedInACorrectWayOn(String pageName) {
        List<Float> fullPrices = ((CategoryPage) PAGES_STORAGE.get(pageName)).getFullPrices();
        //Checking if list is properly sorted
        boolean sorted = Comparators.isInOrder(fullPrices, Comparator.naturalOrder());
        //The assertion sometimes fails because amazon website doesn't always sort prices properly
        Assert.assertTrue(sorted,
                "Sorting of the prices is not as selected");
    }
}
