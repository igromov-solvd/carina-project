package com.solvd.selenium;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.pages.common.ShoppingBagPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BagTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // Store shopping bag page reference to be used in dependent test
    private ShoppingBagPageBase shoppingBagPage;

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
        shoppingBagPage = productPage.clickViewBagButton();

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

    /**
     * NEXT_006 - Verify Remove Product from Bag
     *
     * Test to verify that a user can remove a product from the shopping bag.
     * This test depends on the first test to have a product already in the bag,
     * eliminating duplicate setup code.
     */
    @Test(description = "Verify remove product from bag functionality", dependsOnMethods = "testAddToBag")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    @Parameters({ "category", "subCategory" })
    public void testRemoveFromBag(
            @Optional("women") String category,
            @Optional("All Dresses") String subCategory) {
        LOGGER.info("Starting remove from bag test");

        // Use the shopping bag page from the previous test
        Assert.assertNotNull(shoppingBagPage, "Shopping bag page should be available from previous test");

        // Remove item
        shoppingBagPage.clickFirstItemRemoveButton();

        verifyEmptyBagState(shoppingBagPage);

        // Continue shopping
        shoppingBagPage.clickContinueShopping();

        // Verify navigation back to homepage
        Assert.assertTrue(getDriver().getCurrentUrl().contains(R.CONFIG.get("url")),
                "Should be back on homepage after continuing shopping");

        LOGGER.info("Remove from bag test completed successfully");
    }

    private void verifyEmptyBagState(ShoppingBagPageBase shoppingBagPage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(shoppingBagPage.isEmptyBagMessagePresent(),
                "Bag should be empty after removal");
        softAssert.assertEquals(shoppingBagPage.getEmptyBagMessageText(), "Your bag is empty",
                "Empty bag message is incorrect");
        softAssert.assertTrue(shoppingBagPage.isContinueShoppingButtonPresent(),
                "`Continue Shopping` button should be present");
        softAssert.assertAll();
    }
}