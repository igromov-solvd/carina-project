package com.solvd.selenium.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.pages.common.ShoppingBagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShoppingBagPageBase clickViewBagButton() {
        // TODO: implement logic
        return null;
    }

    @Override
    public void selectFirstAvailableSize() {
        // TODO: implement logic
    }

    @Override
    public boolean isAddToBagConfirmationVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isProductNameVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isProductPriceVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isProductDescriptionVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean areProductImagesVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isSizeSelectionVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isColorSelectionVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isAddToBagButtonVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFavouriteButtonVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean hasReviewsSection() {
        // TODO: implement logic
        return false;
    }

    @Override
    public void clickAddToBag() {
        // TODO: implement logic
    }

    @Override
    public boolean isCheckoutButtonVisible() {
        // TODO: implement logic
        return false;
    }

    @Override
    public void clickCheckoutButton() {
        // TODO: implement logic
    }

}
