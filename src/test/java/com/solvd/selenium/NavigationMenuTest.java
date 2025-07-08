package com.solvd.selenium;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NavigationMenuTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * NEXT_003 - Verify Navigation Menu - Category Page Load
     *
     * Test to verify that the navigation menu allows users to navigate to a
     * category page.
     * This includes checking the visibility of the sub-menu, clicking on a
     * sub-category,
     * and verifying that the category page loads with products, filters, and
     * sorting options.
     */
    @Test(description = "Verify navigation menu category page load")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    @Parameters({ "category", "subCategory", "expectedTitle" })
    public void testCategoryNavigation(
            @Optional("women") String category,
            @Optional("All Dresses") String subCategory,
            @Optional("women's dresses") String expectedTitle) {
        LOGGER.info("Starting category navigation test for {} > {}", category, subCategory);

        HomePageBase homePage = navigateToHomePage();

        // Hover over Women category
        CategoryPageBase categoryPage = homePage.hoverOverMainCategoryAndClick(category, subCategory);
        Assert.assertNotNull(categoryPage, "Category page should not be null");

        verifyCategoryPageElements(categoryPage, expectedTitle);
        LOGGER.info("Category navigation test completed successfully");
    }

    private void verifyCategoryPageElements(CategoryPageBase categoryPage, String expectedTitle) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(categoryPage.getPageTitle().toLowerCase(), expectedTitle.toLowerCase(),
                "Category page title should match expected title");
        softAssert.assertTrue(categoryPage.areAllProductsPresent(), "All products should be present");
        softAssert.assertTrue(categoryPage.areFiltersVisible(), "Filters should be visible");
        softAssert.assertTrue(categoryPage.isSortingVisible(), "Sorting options should be visible");
        softAssert.assertAll();
    }
}