package com.solvd.selenium;

import com.solvd.selenium.components.HeaderComponent;
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
            "Women", "Men", "Boys", "Girls", "Home", "Baby",
            "Furniture", "Holiday", "School", "Brands", "Beauty", "Gifts",
            "Sports", "Sale");

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
        HeaderComponent header = homePage.getHeader();

        verifyDeliverySection(header);
        verifyHeaderElements(header);
        verifyMainMenuCategories(header);

        LOGGER.info("Homepage elements verification test completed successfully");
    }

    private void verifyDeliverySection(HeaderComponent header) {
        Assert.assertTrue(header.isDeliveryTitlePresent(), "Delivery title should be present");
        Assert.assertEquals(header.getDeliveryTitleText(),
                "Next day delivery to home or free to store*",
                "Delivery title text is incorrect");
    }

    private void verifyHeaderElements(HeaderComponent header) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(header.isStoreLocatorPresent(), "Store Locator link should be present");
        softAssert.assertTrue(header.isHelpLinkPresent(), "Help link should be present");
        softAssert.assertTrue(header.isLogoPresent(), "Next logo should be present");
        softAssert.assertTrue(header.isSearchBarPresent(), "Search bar should be present");
        softAssert.assertTrue(header.isAccountIconPresent(), "Account icon should be present");
        softAssert.assertTrue(header.isFavoritesIconPresent(), "Favorites icon should be present");
        softAssert.assertTrue(header.isShoppingBagIconPresent(), "Shopping bag icon should be present");
        softAssert.assertTrue(header.isCheckoutButtonPresent(), "Checkout button should be present");
        softAssert.assertAll();
    }

    private void verifyMainMenuCategories(HeaderComponent header) {
        Assert.assertEquals(header.getMainMenuCategoriesList(), EXPECTED_CATEGORIES,
                "Main menu categories are incorrect");
    }
}