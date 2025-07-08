package com.solvd.selenium.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.pages.common.ShoppingBagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShoppingBagPageBase.class)
public class ShoppingBagPage extends ShoppingBagPageBase {

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFirstItemPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFirstItemPricePresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFirstItemQuantityPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public boolean isFirstItemRemoveButtonPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public void clickFirstItemRemoveButton() {
        // TODO: implement logic
    }

    @Override
    public boolean isEmptyBagMessagePresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public String getEmptyBagMessageText() {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean isContinueShoppingButtonPresent() {
        // TODO: implement logic
        return false;
    }

    @Override
    public void clickContinueShopping() {
        // TODO: implement logic
    }

    @Override
    public int getQuantity() {
        // TODO: implement logic
        return 0;
    }

    @Override
    public void clickOnQuantityCountPlus() {
        // TODO: implement logic
    }

    @Override
    public double getProductPrice() {
        // TODO: implement logic
        return 0.0;
    }

    @Override
    public void waitForTotalPriceChanged(Double expectedNewValue) {
        // TODO: implement logic
    }
}
