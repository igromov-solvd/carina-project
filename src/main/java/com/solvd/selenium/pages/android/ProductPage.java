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
    public boolean isAddToBagConfirmationPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isProductNamePresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isProductPricePresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isProductDescriptionPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean areAllProductImagesPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isSizeSelectorPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isColorSelectorPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isAddToBagButtonPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFavouriteButtonPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isReviewsSectionPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public void clickAddToBag() {
        // TODO: implement logic
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public void clickCheckoutButton() {
        // TODO: implement logic
    }

}
