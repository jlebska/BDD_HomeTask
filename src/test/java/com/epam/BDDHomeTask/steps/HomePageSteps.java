package com.epam.BDDHomeTask.steps;

import com.epam.BDDHomeTask.pageobject.pages.CategoryPage;
import com.epam.BDDHomeTask.pageobject.pages.HomePage;
import io.cucumber.java.en.Given;

import static com.epam.BDDHomeTask.steps.BaseSteps.PAGES_STORAGE;
import static com.epam.BDDHomeTask.steps.BaseSteps.webDriver;

public class HomePageSteps {
    @Given("User is on {string} for {string} category")
    public void userIsOnForCategory(String pageName, String categoryName) {
        CategoryPage categoryPage = new HomePage(webDriver)
                .open()
                .openCategory(categoryName);
        PAGES_STORAGE.put(pageName, categoryPage);
    }
}
