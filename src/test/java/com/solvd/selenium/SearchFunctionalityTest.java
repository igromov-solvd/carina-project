package com.solvd.selenium;

import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.SearchResultsPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * NEXT_002 - Verify Search Functionality - Valid Product
     *
     * Test to verify the search functionality on the homepage.
     * This includes searching for a valid product and checking
     * the search results page for relevant products, filters, and sorting options.
     */
    @Test(description = "Verify search functionality with valid product")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testValidProductSearch() {
        String searchTerm = "dress";
        LOGGER.info("Starting search functionality test for: {}", searchTerm);

        HomePageBase homePage = navigateToHomePage();
        SearchResultsPageBase searchResultsPage = homePage.searchForProduct(searchTerm);

        // Verify search results page
        Assert.assertTrue(searchResultsPage.getPageTitleText().toLowerCase().contains(searchTerm),
                "Search results title should contain search term");

        // Verify product details visibility
        List<String> productTitles = searchResultsPage.getProductTitles();
        Assert.assertFalse(productTitles.isEmpty(), "Product titles should not be empty");

        // Verify filters and sorting options
        Assert.assertTrue(searchResultsPage.areFiltersVisible(), "Filters should be visible");
        Assert.assertTrue(searchResultsPage.isSortingVisible(), "Sorting options should be visible");

        LOGGER.info("Search functionality test completed successfully");
    }
}
