package com.solvd.selenium.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.components.BagItemComponent;
import com.solvd.selenium.pages.common.BagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BagPageBase.class)
public class BagPage extends BagPageBase {

    public BagPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getBagItemCount() {
        // TODO: implement logic
        return 0;
    }

    @Override
    public BagItemComponent getBagItem(int index) {
        // TODO: implement logic
        return null;
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
    public void waitForTotalPriceChanged(Double expectedNewValue) {
        // TODO: implement logic
    }
}
