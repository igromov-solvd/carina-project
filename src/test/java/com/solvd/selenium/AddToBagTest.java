package com.solvd.selenium;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.pages.common.ShoppingBagPageBase;
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

public class AddToBagTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * NEXT_005 - Verify Add Product to Bag and View Bag
     *
     * Test to verify that a user can add a product to the shopping bag.
     * This includes navigating to a product, selecting size, adding to bag,
     * and verifying the bag contents.
     */
    @Test(description = "Verify add product to bag functionality")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    @Parameters({ "category", "subCategory" })
    public void testAddToBag(
            @Optional("women") String category,
            @Optional("All Dresses") String subCategory) {
        LOGGER.info("Starting add to bag test");

        HomePageBase homePage = navigateToHomePage();

        // Hover over Women category
        CategoryPageBase categoryPage = homePage.hoverOverMainCategoryAndClick(category, subCategory);
        Assert.assertNotNull(categoryPage, "Category page should not be null");

        ProductPageBase productPage = categoryPage.clickFirstProduct();

        // Select size and add to bag
        productPage.selectFirstAvailableSize();
        productPage.clickAddToBag();

        // Verify confirmation
        Assert.assertTrue(productPage.isAddToBagConfirmationPresent(),
                "Add to bag confirmation should be present");

        // View bag from confirmation
        ShoppingBagPageBase shoppingBagPage = productPage.clickViewBagButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(shoppingBagPage.isFirstItemPresent(),
                "Bag item should be present");
        softAssert.assertTrue(shoppingBagPage.isFirstItemPricePresent(),
                "Price should be present");
        softAssert.assertTrue(shoppingBagPage.isFirstItemQuantityPresent(),
                "Quantity should be present");
        softAssert.assertTrue(shoppingBagPage.isFirstItemRemoveButtonPresent(),
                "Remove button should be present");
        softAssert.assertAll();

        LOGGER.info("Add to bag test completed successfully");
    }
}