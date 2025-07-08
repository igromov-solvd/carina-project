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

public class UpdateQuantityTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * NEXT_007 - Verify Update Quantity in Bag
     *
     * Test to verify that a user can update the quantity of a product in the
     * shopping bag.
     * This includes starting from the shopping bag page, updating the quantity,
     * and verifying that the subtotal reflects the new quantity.
     */
    @Test(description = "Verify update quantity in bag functionality")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    @Parameters({ "category", "subCategory", "newQuantity" })
    public void testUpdateQuantity(
            @Optional("women") String category,
            @Optional("All Dresses") String subCategory,
            @Optional("2") int newQuantity) {
        LOGGER.info("Starting update quantity test");

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

        // Get initial price
        double initialPrice = shoppingBagPage.getProductPrice();

        // Update quantity
        shoppingBagPage.clickOnQuantityCountPlus();

        // Verify updates
        Assert.assertEquals(shoppingBagPage.getQuantity(), newQuantity,
                "Quantity should be updated");

        // Verify total price reflects new quantity
        shoppingBagPage.waitForTotalPriceChanged(initialPrice * newQuantity);

        LOGGER.info("Update quantity test completed successfully");
    }
}