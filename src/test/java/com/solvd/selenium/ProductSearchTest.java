package com.solvd.selenium;

import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.SearchResultsPageBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ProductSearchTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "Search for a product and validate results")
    public void testProductSearch() {
        String searchTerm = "jeans";
        LOGGER.info("Starting product search test for: {}", searchTerm);

        HomePageBase homePage = navigateToHomePage();

        SearchResultsPageBase searchResultsPage = homePage.searchForProduct(searchTerm);

        List<String> productTitles = searchResultsPage.getProductTitles();
        Assert.assertFalse(productTitles.isEmpty(),
                "Product titles list should not be empty");

        searchResultsPage.printAllProductTitles();

        LOGGER.info("Found {} products", productTitles.size());

        long relevantProducts = productTitles.stream()
                .filter(title -> title.toLowerCase().contains(searchTerm.toLowerCase()) ||
                        title.toLowerCase().contains("stretch") ||
                        title.toLowerCase().contains("slim"))
                .count();

        LOGGER.info("Found {} relevant products out of {} total products",
                relevantProducts, productTitles.size());

        Assert.assertTrue(relevantProducts > 0,
                "Expected at least one product to match relevance criteria");
    }
}