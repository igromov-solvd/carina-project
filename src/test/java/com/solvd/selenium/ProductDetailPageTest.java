package com.solvd.selenium;

import com.solvd.selenium.components.ProductComponent;
import com.solvd.selenium.pages.common.CategoryPageBase;
import com.solvd.selenium.pages.common.HomePageBase;
import com.solvd.selenium.pages.common.ProductPageBase;
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

public class ProductDetailPageTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * NEXT_004 - Verify Product Detail Page - View Product Information
     *
     * Test to verify that the product detail page displays all necessary
     * information
     * about a product, including name, price, description, images, size and color
     * options,
     * add to bag button, favorite button, and reviews section.
     */
    @Test(description = "Verify product detail page information")
    @MethodOwner(owner = "igromov")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    @Parameters({ "category", "subCategory" })
    public void testProductDetailPage(
            @Optional("women") String category,
            @Optional("All Dresses") String subCategory) {
        LOGGER.info("Starting product detail page test");

        HomePageBase homePage = navigateToHomePage();

        // Hover over Women category
        CategoryPageBase categoryPage = homePage.getHeader()
                .hoverOverMainCategoryAndClick(category, subCategory);
        Assert.assertNotNull(categoryPage, "Category page should not be null");

        // Click on first product
        ProductPageBase productPage = categoryPage.clickFirstProduct();
        ProductComponent productComponent = productPage.getProduct();
        Assert.assertNotNull(productComponent, "Product component should not be null");

        verifyProductDetails(productComponent);
        LOGGER.info("Product detail page test completed successfully");
    }

    private void verifyProductDetails(ProductComponent productComponent) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(productComponent.isProductNamePresent(),
                "Product name should be present");
        softAssert.assertTrue(productComponent.isProductPricePresent(),
                "Product price should be present");
        softAssert.assertTrue(productComponent.isReviewsSectionPresent(),
                "Reviews section should be present if available");
        softAssert.assertTrue(productComponent.areAllProductImagesPresent(),
                "Product images should be present");
        softAssert.assertTrue(productComponent.isSizeSelectorPresent(),
                "Size selection should be available");
        softAssert.assertTrue(productComponent.isColorSelectorPresent(),
                "Color selection should be available");
        softAssert.assertTrue(productComponent.isAddToBagButtonPresent(),
                "Add to Bag button should be present");
        softAssert.assertTrue(productComponent.isFavouriteButtonPresent(),
                "Favourite button should be present");
        softAssert.assertTrue(productComponent.isProductDescriptionPresent(),
                "Product description should be present");

        softAssert.assertAll();
    }
}