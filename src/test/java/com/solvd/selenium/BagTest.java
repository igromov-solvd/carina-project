package com.solvd.selenium;

import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.components.BagItemComponent;
import com.solvd.selenium.components.ProductComponent;
import com.solvd.selenium.pages.common.BagPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BagTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private BagPageBase bagPage;

    @BeforeMethod
    @Parameters({ "category", "subCategory" })
    public void setupBag(@Optional("women") String category,
            @Optional("All Dresses") String subCategory) {
        LOGGER.info("Setting up initial bag state");

        HomePageBase homePage = navigateToHomePage();
        CategoryPageBase categoryPage = homePage.getHeader()
                .hoverOverMainCategoryAndClick(category, subCategory);
        Assert.assertNotNull(categoryPage, "Category page should not be null");

        ProductPageBase productPage = categoryPage.clickFirstProduct();
        ProductComponent productComponent = productPage.getProduct();
        Assert.assertNotNull(productComponent, "Product component should not be null");
        productComponent.selectFirstAvailableSize();
        productComponent.clickAddToBag();
        Assert.assertTrue(productPage.isAddToBagConfirmationPresent(),
                "Add to bag confirmation should be present");

        bagPage = productPage.clickViewBagButton();
        Assert.assertEquals(bagPage.getBagItemCount(), 1,
                "Bag should contain one item after adding");

        LOGGER.info("Bag setup completed successfully");
    }

    @Test(description = "Verify add product to bag functionality")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testAddToBag() {
        LOGGER.info("Starting add to bag test");

        verifyBagItemPresent(bagPage, 0);

        LOGGER.info("Add to bag test completed successfully");
    }

    @Test(description = "Verify remove product from bag functionality")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testRemoveFromBag() {
        LOGGER.info("Starting remove from bag test");

        Assert.assertEquals(bagPage.getBagItemCount(), 1,
                "Bag should contain exactly one item before removing");
        bagPage.getBagItem(0).clickRemoveButton();

        verifyEmptyBagState(bagPage);

        bagPage.clickContinueShopping();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(R.CONFIG.get("url")),
                "Should be back on homepage after continuing shopping");

        LOGGER.info("Remove from bag test completed successfully");
    }

    @Test(description = "Verify update quantity in bag functionality")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    @Parameters({ "newQuantity" })
    public void testUpdateQuantity(@Optional("2") int newQuantity) {
        LOGGER.info("Starting update quantity test");

        BagItemComponent firstItem = bagPage.getBagItem(0);
        double initialPrice = firstItem.getItemPrice();
        firstItem.clickQuantityPlus();

        Assert.assertEquals(firstItem.getQuantity(), newQuantity, "Quantity should be updated");
        bagPage.waitForTotalPriceChanged(initialPrice * newQuantity);

        LOGGER.info("Update quantity test completed successfully");
    }

    private void verifyBagItemPresent(BagPageBase bagPage, int itemIndex) {
        SoftAssert softAssert = new SoftAssert();
        BagItemComponent bagItem = bagPage.getBagItem(itemIndex);

        softAssert.assertTrue(bagItem.isItemPricePresent(),
                "Item price should be present");
        softAssert.assertTrue(bagItem.isQuantityControlPresent(),
                "Quantity control should be present");
        softAssert.assertTrue(bagItem.isRemoveButtonPresent(),
                "Remove button should be present");
        softAssert.assertTrue(bagItem.getItemPrice() > 0,
                "Item price should be greater than 0");
        softAssert.assertTrue(bagItem.getQuantity() > 0,
                "Item quantity should be greater than 0");

        softAssert.assertAll();
    }

    private void verifyEmptyBagState(BagPageBase bagPage) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(bagPage.isEmptyBagMessagePresent(),
                "Bag should be empty after removal");
        softAssert.assertEquals(bagPage.getEmptyBagMessageText(), "Your bag is empty",
                "Empty bag message is incorrect");
        softAssert.assertTrue(bagPage.isContinueShoppingButtonPresent(),
                "`Continue Shopping` button should be present");

        softAssert.assertAll();
    }
}