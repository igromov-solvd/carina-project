package com.solvd.selenium;

import com.solvd.selenium.pages.common.HomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final List<String> EXPECTED_CATEGORIES = Arrays.asList(
            "women", "men", "boys", "girls", "home", "baby",
            "furniture", "holiday", "school", "brands", "beauty", "gifts",
            "sports", "sale");

    /**
     * NEXT_001 - Verify Homepage Load and Essential Elements
     * 
     * Test to verify essential elements on the homepage.
     * This includes checking the visibility of the delivery title,
     * store locator, help link, logo, search bar, account icon,
     * favorites icon, shopping bag icon, checkout button, and main menu.
     */
    @Test(description = "Verify homepage load and essential elements")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testHomePageElements() {
        LOGGER.info("Starting homepage elements verification test");

        HomePageBase homePage = navigateToHomePage();

        verifyDeliverySection(homePage);
        verifyHeaderElements(homePage);
        verifyMainMenuCategories(homePage);

        LOGGER.info("Homepage elements verification test completed successfully");
    }

    private void verifyDeliverySection(HomePageBase homePage) {
        Assert.assertTrue(homePage.isDeliveryTitlePresent(), "Delivery title should be present");
        Assert.assertEquals(homePage.getDeliveryTitleText(),
                "Next day delivery to home or free to store*",
                "Delivery title text is incorrect");
    }

    private void verifyHeaderElements(HomePageBase homePage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isStoreLocatorPresent(), "Store Locator link should be present");
        softAssert.assertTrue(homePage.isHelpLinkPresent(), "Help link should be present");
        softAssert.assertTrue(homePage.isLogoPresent(), "Next logo should be present");
        softAssert.assertTrue(homePage.isSearchBarPresent(), "Search bar should be present");
        softAssert.assertTrue(homePage.isAccountIconPresent(), "Account icon should be present");
        softAssert.assertTrue(homePage.isFavoritesIconPresent(), "Favorites icon should be present");
        softAssert.assertTrue(homePage.isShoppingBagIconPresent(), "Shopping bag icon should be present");
        softAssert.assertTrue(homePage.isCheckoutButtonPresent(), "Checkout button should be present");
        softAssert.assertAll();
    }

    private void verifyMainMenuCategories(HomePageBase homePage) {
        Assert.assertEquals(homePage.getMainMenuCategoriesList(), EXPECTED_CATEGORIES,
                "Main menu categories are incorrect");
    }
}