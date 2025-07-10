package com.solvd.selenium.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.selenium.pages.common.ProductPageBase;
import com.solvd.selenium.components.ProductComponent;
import com.solvd.selenium.pages.common.BagPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductComponent getProduct() {
        // TODO: implement logic
        return null;
    }

    @Override
    public BagPageBase clickViewBagButton() {
        // TODO: implement logic
        return null;
    }

    @Override
    public boolean isAddToBagConfirmationPresent() {
        // TODO: implement logic
        return false;
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
